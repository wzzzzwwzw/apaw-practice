package es.upm.miw.apaw_practice.domain.models.film;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
class DirectorIT {

    @Test
    void testDirectorBuilder() {
        Director director = new Director.Builder()
                .dni("00")
                .name("Juan")
                .dateOfBirth(LocalDate.of(2000, 3, 12))
                .build();
        assertNotNull(director);
        assertEquals("00", director.getDni());
        assertEquals("Juan", director.getName());
    }
}
