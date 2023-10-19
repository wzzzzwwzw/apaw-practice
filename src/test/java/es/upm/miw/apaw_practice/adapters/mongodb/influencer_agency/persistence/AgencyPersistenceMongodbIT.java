package es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.daos.AgencyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.entities.AgencyEntity;
import es.upm.miw.apaw_practice.domain.models.influencer_agency.Agency;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class AgencyPersistenceMongodbIT {

    @Autowired
    private AgencyPersistenceMongodb agencyPersistence;

    @Autowired
    private AgencyRepository agencyRepository;

    @BeforeEach
    void seedDatabase() {
        agencyRepository.save(new AgencyEntity(new Agency("TestAgency1", "TestAddress1")));
        agencyRepository.save(new AgencyEntity(new Agency("TestAgency2", "TestAddress2")));
        agencyRepository.save(new AgencyEntity(new Agency("AnotherAgency", "AnotherAddress")));
    }

    @AfterEach
    void cleanDatabase() {
        agencyRepository.deleteAll();
    }

    @Test
    void testDeleteAgenciesStartingWith() {
        agencyPersistence.deleteAgenciesStartingWith("Test");

        List<AgencyEntity> agencies = agencyRepository.findAll();

        assertTrue(agencies.stream().noneMatch(agency -> agency.getCompany().startsWith("Test")));
        assertTrue(agencies.stream().anyMatch(agency -> agency.getCompany().equals("AnotherAgency")));
    }
}
