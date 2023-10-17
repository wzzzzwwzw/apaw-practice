package es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.entities.AgencyEntity;
import es.upm.miw.apaw_practice.domain.models.influencer_agency.Agency;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class AgencyRepositoryIT {

    @Autowired
    private AgencyRepository agencyRepository;

    @Test
    void testDeleteByCompanyStartingWithIgnoreCase() {
        AgencyEntity agencyEntity = new AgencyEntity(new Agency("AgencyThis", "Madrid"));
        this.agencyRepository.save(agencyEntity);
        assertTrue(this.agencyRepository.findAll().stream()
                .anyMatch(agency -> "AgencyThis".equals(agency.getCompany())));
        this.agencyRepository.deleteByCompanyStartingWithIgnoreCase("AgencyThis");
        assertTrue(this.agencyRepository.findAll().stream()
                .noneMatch(agency -> "AgencyThis".equals(agency.getCompany())));

    }
}
