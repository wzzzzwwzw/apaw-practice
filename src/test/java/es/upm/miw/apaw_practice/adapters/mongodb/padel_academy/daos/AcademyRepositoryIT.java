package es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.entities.AcademyEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class AcademyRepositoryIT {
    @Autowired
    private AcademyRepository academyRepository;

    @Test
    void testFindByName() {
        assertTrue(this.academyRepository.findByName("Ocio y Deporte Canal").isPresent());
        AcademyEntity academy = this.academyRepository.findByName("Ocio y Deporte Canal").get();
        assertEquals("Madrid", academy.getCity());
        assertEquals("Avda. Filipinas, esq. Pablo Iglesias, 28003", academy.getAddress());
    }
}
