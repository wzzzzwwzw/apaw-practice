package es.upm.miw.apaw_practice.adapters.mongodb.music.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.AlbumEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.ArtistEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.GenreEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.SongEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class AlbumRepositoryIT {

    @Autowired
    private AlbumRepository albumRepository;

    @Test
    void testFindByDenomination() {
        assertTrue(this.albumRepository.findByDenomination("Colores").isPresent());
        AlbumEntity album = this.albumRepository.findByDenomination("Colores").get();
        GenreEntity genre1 = new GenreEntity("reggaeton", "reggaeton music", 10, "Puerto Rico");
        GenreEntity genre2 = new GenreEntity("rock", "rock music", 9, "United Kingdom");
        ArtistEntity artist1 = new ArtistEntity("12345678A", "J Balvin", 123456789, LocalDate.of(1986, 3, 6));
        ArtistEntity artist2 = new ArtistEntity("22222222D", "Ozuna", 222222222, LocalDate.of(1989, 12, 30));
        ArtistEntity artist3 = new ArtistEntity("33333333E", "Chencho Corleone", 333333333, LocalDate.of(2001, 5, 24));
        ArtistEntity artist4 =  new ArtistEntity("87654321B", "Ska-P", 987654321, LocalDate.of(1974, 11, 19));
        SongEntity song1 = new SongEntity("Una Locura", 3, false, 4.0, genre1, Arrays.asList(artist1, artist2, artist3));
        SongEntity song2 = new SongEntity("El Vals del Obrero", 5, false, 4.0, genre2, Collections.singletonList(artist4));

        assertEquals("Colores", album.getDenomination());
        assertEquals(LocalDateTime.of(2010, 5, 17, 12, 16, 17), album.getReleaseDate());
        assertEquals("La Industria Inc", album.getRecordLabel());
        assertEquals(Arrays.asList(song1, song2), album.getSongsList());
    }
}
