package es.upm.miw.apaw_practice.domain.models.music;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MusicGenreIT {

    @Test
    void testMusicGenreBuilder() {
        MusicGenre musicGenre = new MusicGenre.Builder()
                .type("flamenco")
                .description("flamenco music")
                .popularity(11)
                .countryOrigin("Spain")
                .build();
        assertNotNull(musicGenre);
        assertEquals("flamenco", musicGenre.getType());
        assertEquals("flamenco music", musicGenre.getDescription());
        assertEquals(11, musicGenre.getPopularity());
        assertEquals("Spain", musicGenre.getCountryOrigin());
    }
}
