package es.upm.miw.apaw_practice.adapters.mongodb.subway.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.entities.StationEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class StationRepositoryIT {

    @Autowired
    private StationRepository stationRepository;

    @Test
    void testFindByName() {
        assertTrue(this.stationRepository.findByName("Canal").isPresent());
        StationEntity station = this.stationRepository.findByName("Canal").get();
        assertEquals("Canal", station.getName());
    }

}
