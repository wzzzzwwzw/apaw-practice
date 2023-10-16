package es.upm.miw.apaw_practice.adapters.mongodb.subway.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.SubwaySeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.subway.Line;
import es.upm.miw.apaw_practice.domain.models.subway.Subway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class SubwayPersistenceMongodbIT {

    @Autowired
    private SubwayPersistenceMongodb subwayPersistenceMongodb;

    @Autowired
    private SubwaySeederService subwaySeederService;

    @Test
    void testGetSubway() {
        Subway subway = this.subwayPersistenceMongodb.readByCity("Madrid");
        assertEquals("Madrid", subway.getCity());

    }

    @Test
    void testGetLine() {
        Line line = this.subwayPersistenceMongodb.findLineByCityAndLabel("Madrid", "Red Line");
        assertEquals("Red Line", line.getLabel());
        assertThrows(NotFoundException.class, () -> this.subwayPersistenceMongodb.findLineByCityAndLabel("Madrid", "Pink Line"));

    }

}
