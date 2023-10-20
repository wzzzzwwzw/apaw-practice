package es.upm.miw.apaw_practice.domain.services.music;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.music.MusicSeederService;
import es.upm.miw.apaw_practice.domain.models.music.Artist;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class ArtistServiceIT {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private MusicSeederService musicSeederService;

    @AfterEach
    void resetDB() {
        this.musicSeederService.deleteAll();
        this.musicSeederService.seedDatabase();
    }

    @Test
    void testUpdatePhoneNumber() {
        Artist artist = this.artistService.updatePhoneNumber("22222222D", 666666666);
        assertEquals("22222222D", artist.getDni());
        assertEquals("Ozuna", artist.getFullName());
        assertEquals(666666666, artist.getPhoneNumber());
        assertEquals(LocalDate.of(1989, 12, 30), artist.getBirthDate());
    }

    @Test
    void testGetPhoneNumbersByTypeAndRecordLabel() {
        List<Integer> phoneNumbers = this.artistService
                .getPhoneNumbersByTypeAndRecordLabel("reggaeton", "La Industria Inc")
                .toList();
        assertEquals(3, phoneNumbers.size());
        assertTrue(phoneNumbers.contains(123456789));
        assertTrue(phoneNumbers.contains(222222222));
        assertTrue(phoneNumbers.contains(333333333));
    }
}
