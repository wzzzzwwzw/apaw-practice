package es.upm.miw.apaw_practice.adapters.mongodb.conference.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@TestConfig
class ConferenceLocationRepositoryIT {
    @Autowired
    private ConferenceLocationRepository conferenceLocationRepository;

    @Test
    void testCreateAndRead() {
        Assertions.assertTrue(this.conferenceLocationRepository.findAll().stream()
                .anyMatch(conferenceLocation ->
                        "Florence".equals(conferenceLocation.getCity()) &&
                                "Meyer Health Campus".equals(conferenceLocation.getBuilding()) &&
                                "Main hall".equals(conferenceLocation.getHall())
                ));
    }
}
