package es.upm.miw.apaw_practice.domain.services.music;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.music.Artist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class ArtistServiceIT {

    @Autowired
    private ArtistService artistService;

    @Test
    void testUpdatePhoneNumber() {
        Artist artist = this.artistService.updatePhoneNumber("22222222D", 666666666);
        assertEquals("22222222D", artist.getDni());
        assertEquals("Ozuna", artist.getFullName());
        assertEquals(666666666, artist.getPhoneNumber());
        assertEquals(LocalDate.of(1989, 12, 30), artist.getBirthDate());

    }
}
