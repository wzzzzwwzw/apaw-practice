package es.upm.miw.apaw_practice.adapters.mongodb.subway.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.SubwaySeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.subway.Station;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class StationPersistenceMongodbIT {

    @Autowired
    private StationPersistenceMongodb stationPersistenceMongodb;

    @Autowired
    private SubwaySeederService subwaySeederService;

    @Test
    void testCreateAndRead() {
        Station station = new Station("Sol", "RED-4#", true);
        this.stationPersistenceMongodb.create(station);
        Station stationBD = this.stationPersistenceMongodb.readByName("Sol");
        assertEquals("Sol", stationBD.getName());
        assertThrows(NotFoundException.class, () -> this.stationPersistenceMongodb.readByName("Sagrada Familia"));
    }

}
