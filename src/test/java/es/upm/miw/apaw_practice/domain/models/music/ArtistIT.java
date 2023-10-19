package es.upm.miw.apaw_practice.domain.models.music;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ArtistIT {

    @Test
    void testArtistBuilder() {
        Artist artist = new Artist.Builder()
                .dni("45971733T")
                .fullName("Juan Carlos Guillen")
                .phoneNumber(722680349)
                .birthDate(LocalDate.of(2001, 11, 12))
                .build();
        assertNotNull(artist);
        assertEquals("45971733T", artist.getDni());
        assertEquals("Juan Carlos Guillen", artist.getFullName());
        assertEquals(722680349, artist.getPhoneNumber());
        assertEquals(LocalDate.of(2001, 11, 12), artist.getBirthDate());

    }
}
