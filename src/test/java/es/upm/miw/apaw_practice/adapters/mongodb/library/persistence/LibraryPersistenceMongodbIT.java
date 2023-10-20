package es.upm.miw.apaw_practice.adapters.mongodb.library.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class LibraryPersistenceMongodbIT {
    @Autowired
    private LibraryPersistenceMongodb libraryPersistence;

    @Test
    void testReadNotFound() {
        assertThrows(NotFoundException.class, () -> this.libraryPersistence.read("."));
    }

    @Test
    void testReadFound() {
        assertNotNull(this.libraryPersistence.read("Biblioteca universitaria"));
    }
    @Test
    void testFindNumberOfBookAverageByLibraryName(){
        assertEquals(new BigDecimal("20.50"), this.libraryPersistence.findAverageOfNumberOfBookByLibraryName("Biblioteca universitaria"));
    }
}
