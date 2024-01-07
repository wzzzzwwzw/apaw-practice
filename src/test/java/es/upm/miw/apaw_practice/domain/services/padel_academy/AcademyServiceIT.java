package es.upm.miw.apaw_practice.domain.services.padel_academy;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.PadelAcademySeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.padel_academy.Academy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class AcademyServiceIT {
    @Autowired
    private AcademyService academyService;
    @Autowired
    private PadelAcademySeederService padelAcademySeederService;

    @AfterEach
    void resetDatabase() {
        this.padelAcademySeederService.deleteAll();
        this.padelAcademySeederService.seedDatabase();
    }

    @Test
    void testRead() {
        Academy academy = this.academyService.read("Ocio y Deporte Canal");
        assertEquals("Ocio y Deporte Canal", academy.getName());
        assertEquals("Avda. Filipinas, esq. Pablo Iglesias, 28003", academy.getAddress());
        assertEquals("Madrid", academy.getCity());
    }

    @Test
    void testReadNotFound() {
        RuntimeException exception = assertThrows(NotFoundException.class, () -> {
            this.academyService.read("Ocio");
        });
        assertTrue(exception.getMessage().contains("Academy with name Ocio not found."));
    }

    @Test
    void testDelete() {
        this.academyService.delete("Ocio y Deporte Canal");
    }
}
