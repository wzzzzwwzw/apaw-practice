package es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.InfluencerAgencySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.daos.BrandRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.entities.BrandEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class BrandPersistenceMongodbIT {

    @Autowired
    private BrandPersistenceMongodb brandPersistence;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private InfluencerAgencySeederService influencerAgencySeederService;

    @BeforeEach
    void resetDB() {
        this.influencerAgencySeederService.deleteAll();
        this.influencerAgencySeederService.seedDatabase();
    }

    @Test
    void testGetCampaignsByBrand() {
        var campaigns = this.brandPersistence.getCampaignsByBrand("Brand1").toList();
        assertFalse(campaigns.isEmpty());
        assertTrue(campaigns.stream().anyMatch(campaign -> campaign.getDescription().equals("Description1")));
    }

    @Test
    void testGetCampaignsByBrandNotFound() {
        assertThrows(NotFoundException.class, () -> this.brandPersistence.getCampaignsByBrand("UnknownBrand"));
    }

    @Test
    void testUpdateBrand() {
        this.brandPersistence.updateBrand("Brand1", BigDecimal.TEN);
        BrandEntity brand = this.brandRepository.findByTrademark("Brand1").orElseThrow();
        assertEquals(0, brand.getAdvertisingBudget().compareTo(BigDecimal.TEN));
    }


    @Test
    void testUpdateBrandNotFound() {
        assertThrows(NotFoundException.class, () -> this.brandPersistence.updateBrand("UnknownBrand", BigDecimal.TEN));
    }

    @Test
    void testSumBudgetsByPlatform() {
        BigDecimal sum = this.brandPersistence.sumBudgetsByPlatform("Platform3");
        assertEquals(1, sum.compareTo(new BigDecimal("209.00")));
    }


    @Test
    void testSumBudgetsByPlatformNotFound() {
        assertThrows(NotFoundException.class, () -> this.brandPersistence.sumBudgetsByPlatform("UnknownPlatform"));
    }
}
