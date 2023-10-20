package es.upm.miw.apaw_practice.adapters.mongodb.subway.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.SubwaySeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.subway.Line;
import es.upm.miw.apaw_practice.domain.models.subway.Subway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class SubwayPersistenceMongodbIT {

    @Autowired
    private SubwayPersistenceMongodb subwayPersistenceMongodb;

    @Autowired
    private SubwaySeederService subwaySeederService;

    @BeforeEach
    void resetDataBase() {
        this.subwaySeederService.deleteAll();
        this.subwaySeederService.seedDatabase();
    }

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

    @Test
    void testPutLine() {
        Subway subway = this.subwayPersistenceMongodb.readByCity("Madrid");
        assertEquals("Madrid", subway.getCity());
        subway.getLines().get(1).setLabel("Blue Line");
        Subway update = this.subwayPersistenceMongodb.update(subway);
        assertEquals("Blue Line", update.getLines().get(1).getLabel());
        Line line = this.subwayPersistenceMongodb.findLineByCityAndLabel("Madrid", "Blue Line");
        assertEquals("Blue Line", line.getLabel());
        assertThrows(NotFoundException.class, () -> this.subwayPersistenceMongodb.findLineByCityAndLabel("Madrid", "Orange Line"));
    }

}
