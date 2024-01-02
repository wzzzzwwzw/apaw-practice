package es.upm.miw.apaw_practice.adapters.mongodb.music.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.ArtistEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class ArtistRepositoryIT {

    @Autowired
    private ArtistRepository artistRepository;

    @Test
    void testFindByDni() {
        assertTrue(this.artistRepository.findByDni("12345678A").isPresent());
        ArtistEntity artist = this.artistRepository.findByDni("12345678A").get();
        assertEquals("12345678A", artist.getDni());
        assertEquals("J Balvin", artist.getFullName());
        assertEquals(123456789, artist.getPhoneNumber());
        assertEquals(LocalDate.of(1986, 3, 6), artist.getBirthDate());
    }
}