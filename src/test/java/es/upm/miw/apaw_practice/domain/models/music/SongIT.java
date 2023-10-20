package es.upm.miw.apaw_practice.domain.models.music;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SongIT {

    @Test
    void testSongBuilder() {

        Artist artist1 = new Artist.Builder()
                .dni("12345678A")
                .fullName("Mora")
                .phoneNumber(679893416)
                .birthDate(LocalDate.of(1998, 1, 1))
                .build();

        Artist artist2 = new Artist.Builder()
                .dni("12345678C")
                .fullName("Jhay Cortez")
                .phoneNumber(679893345)
                .birthDate(LocalDate.of(1999, 3, 7))
                .build();

        ArrayList<Artist> artistsList = new ArrayList<>();
        artistsList.add(artist1);
        artistsList.add(artist2);

        Song song = new Song.Builder()
                .title("Memorias")
                .duration(4)
                .remix(false)
                .rating(9.9)
                .musicGenre(new MusicGenre.Builder()
                        .type("reggaeton").
                        description("reggaeton music").
                        popularity(11).countryOrigin("Puerto Rico").
                        build())
                .artistsList(artistsList)
                .build();

        assertNotNull(song);
        assertEquals("Memorias", song.getTitle());
        assertEquals(4, song.getDuration());
        assertEquals(false, song.isRemix());
        assertEquals(9.9, song.getRating());
        assertEquals("reggaeton", song.getMusicGenre().getType());
        assertEquals("reggaeton music", song.getMusicGenre().getDescription());
        assertEquals(11, song.getMusicGenre().getPopularity());
        assertEquals("Puerto Rico", song.getMusicGenre().getCountryOrigin());
        assertEquals(2, song.getArtistsList().size());
        assertEquals("12345678A", song.getArtistsList().get(0).getDni());
        assertEquals("Mora", song.getArtistsList().get(0).getFullName());
        assertEquals(679893416, song.getArtistsList().get(0).getPhoneNumber());
        assertEquals(LocalDate.of(1998, 1, 1), song.getArtistsList().get(0).getBirthDate());
        assertEquals("12345678C", song.getArtistsList().get(1).getDni());
        assertEquals("Jhay Cortez", song.getArtistsList().get(1).getFullName());
        assertEquals(679893345, song.getArtistsList().get(1).getPhoneNumber());
        assertEquals(LocalDate.of(1999, 3, 7), song.getArtistsList().get(1).getBirthDate());
    }
}
