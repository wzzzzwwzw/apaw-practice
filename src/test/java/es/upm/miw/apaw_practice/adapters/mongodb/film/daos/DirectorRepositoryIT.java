package es.upm.miw.apaw_practice.adapters.mongodb.film.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.film.entities.DirectorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class DirectorRepositoryIT {

    @Autowired
    private DirectorRepository directorRepository;

    @Test
    void testFindByDni() {
        assertTrue(this.directorRepository.findByDni("12258468Y").isPresent());
        DirectorEntity director = this.directorRepository.findByDni("12258468Y").get();
        assertEquals("Isabel", director.getName());
        assertEquals("Perez", director.getSurname());
    }
}
