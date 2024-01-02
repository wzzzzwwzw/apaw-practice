package es.upm.miw.apaw_practice.adapters.mongodb.film.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class GenrePersistenceMongodbIT {

    @Autowired
    private GenrePersistenceMongodb genrePersistenceMongodb;

    @Test
    void testFindGenreNamesByGenreStyle() {
        List<String> names = this.genrePersistenceMongodb.findGenreNamesByGenreStyle("Absolute");
        assertEquals(1, names.size());
        assertEquals("Action", names.get(0));
    }

    @Test
    void testNotFindGenreNamesByGenreStyle() {
        List<String> names = this.genrePersistenceMongodb.findGenreNamesByGenreStyle("Other");
        assertEquals(0, names.size());
    }
}
