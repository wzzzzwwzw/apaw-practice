package es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.entities.AgencyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.entities.BrandEntity;
import es.upm.miw.apaw_practice.domain.models.influencer_agency.Agency;
import es.upm.miw.apaw_practice.domain.models.influencer_agency.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class BrandRepositoryIT {
    @Autowired
    private BrandRepository brandRepository;

    @Test
    void testFindByTrademark() {
        BrandEntity brandNew = new BrandEntity("BrandNew",
                new AgencyEntity(new Agency("AgencyNew", "AddressNew")), null);
        this.brandRepository.save(brandNew);
        assertTrue(this.brandRepository.findByTrademark("BrandNew").isPresent());
        BrandEntity brand = this.brandRepository.findByTrademark("BrandNew").get();
        assertEquals("BrandNew", brand.getTrademark());
    }

    @Test
    void testFindByAgencyId() {
        assertTrue(this.brandRepository.findByTrademark("Brand1").isPresent());
        BrandEntity brand = this.brandRepository.findByTrademark("Brand1").get();
        assertTrue(this.brandRepository.findByAgencyId(brand.getAgency().getId()).isPresent());
        BrandEntity brandWithId = this.brandRepository.findByAgencyId(brand.getAgency().getId()).get();
        assertEquals("Industry1", brandWithId.getIndustry());
        assertEquals("Agency1", brandWithId.getAgency().getCompany());
        assertEquals(2, brandWithId.getCampaigns().size());
    }
}
