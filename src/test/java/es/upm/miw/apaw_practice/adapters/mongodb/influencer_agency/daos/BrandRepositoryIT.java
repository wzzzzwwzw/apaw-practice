package es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.entities.BrandEntity;
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
        assertTrue(this.brandRepository.findByTrademark("Brand1").isPresent());
        BrandEntity brand = this.brandRepository.findByTrademark("Brand1").get();
        assertEquals("Brand1", brand.getTrademark());
        assertEquals(0, new BigDecimal("1000.00").compareTo(brand.getAdvertisingBudget()));
        assertEquals("Industry1", brand.getIndustry());
        assertEquals("Agency1", brand.getAgency().getCompany());
        assertEquals(2, brand.getCampaigns().size());
    }
}
