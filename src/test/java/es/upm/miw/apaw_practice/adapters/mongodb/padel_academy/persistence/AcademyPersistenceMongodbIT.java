package es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.PadelAcademySeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.padel_academy.Academy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class AcademyPersistenceMongodbIT {
    @Autowired
    private AcademyPersistenceMongodb academyPersistenceMongodb;
    @Autowired
    private PadelAcademySeederService padelAcademySeederService;

    @AfterEach
    void resetDatabase() {
        this.padelAcademySeederService.deleteAll();
        this.padelAcademySeederService.seedDatabase();
    }

    @Test
    void testReadByName() {
        Academy academy = this.academyPersistenceMongodb.readByName("La Masó Sports Club");
        assertEquals("La Masó Sports Club", academy.getName());
        assertEquals("Calle de la Masó 34, 28035", academy.getAddress());
        assertEquals("Madrid", academy.getCity());
    }

    @Test
    void testReadNotFound() {
        RuntimeException exception = assertThrows(NotFoundException.class, () -> {
            this.academyPersistenceMongodb.readByName("Ocio");
        });
        assertTrue(exception.getMessage().contains("Academy with name Ocio not found."));
    }

    @Test
    void testDeleteByName() {
        this.academyPersistenceMongodb.deleteByName("Ocio y Deporte Canal");
    }

    @Test
    void testUpdateAddress() {
        Academy academy = this.academyPersistenceMongodb.readByName("La Masó Sports Club");
        academy.setAddress("Nueva calle. La academia se muda");
        this.academyPersistenceMongodb.updateAddress(academy);
        academy = this.academyPersistenceMongodb.readByName("La Masó Sports Club");
        assertEquals("Nueva calle. La academia se muda", academy.getAddress());
    }
}
