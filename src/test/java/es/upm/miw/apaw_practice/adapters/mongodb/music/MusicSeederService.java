package es.upm.miw.apaw_practice.adapters.mongodb.music;

import es.upm.miw.apaw_practice.adapters.mongodb.music.daos.AlbumRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.music.daos.ArtistRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.music.daos.MusicGenreRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.AlbumEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.ArtistEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.MusicGenreEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.SongEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

@Service
public class MusicSeederService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private MusicGenreRepository musicGenreRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Music Initial Load -----------");
        MusicGenreEntity[] musicGenres = {
                new MusicGenreEntity("reggaeton", "reggaeton music", 10, "Puerto Rico"),
                new MusicGenreEntity("pop", "pop music", 8, "United States"),
                new MusicGenreEntity("rock", "rock music", 9, "United Kingdom"),
                new MusicGenreEntity("rap", "rap music", 7, "United States"),
                new MusicGenreEntity("trap", "trap music", 6, "United States")
        };
        this.musicGenreRepository.saveAll(Arrays.asList(musicGenres));

        ArtistEntity[] artists = {
                new ArtistEntity("12345678A", "J Balvin", 123456789, LocalDate.of(1986, 3, 6)),
                new ArtistEntity("87654321B", "Ska-P", 987654321, LocalDate.of(1974, 11, 19)),
                new ArtistEntity("11111111C", "Taylor Swift", 111111111, LocalDate.of(1999, 12, 17)),
                new ArtistEntity("22222222D", "Ozuna", 222222222, LocalDate.of(1989, 12, 30)),
                new ArtistEntity("33333333E", "Chencho Corleone", 333333333, LocalDate.of(2001, 5, 24))
        };
        this.artistRepository.saveAll(Arrays.asList(artists));

        SongEntity[] songs = {
                new SongEntity("Skake it off", 4, false, 4.5, musicGenres[1], Collections.singletonList(artists[2])),
                new SongEntity("Una Locura", 3, false, 4.0, musicGenres[0], Arrays.asList(artists[0], artists[3], artists[4])),
                new SongEntity("La Curiosidad", 7, true, 3.5, musicGenres[0], Arrays.asList(artists[0], artists[3])),
                new SongEntity("El Vals del Obrero", 5, false, 4.0, musicGenres[2], Collections.singletonList(artists[1])),
        };

        AlbumEntity[] albums = {
                new AlbumEntity("Fearless", LocalDateTime.of(2007, 3, 23, 12, 45, 14), "Taylor Company", Arrays.asList(songs[0], songs[2])),
                new AlbumEntity("Colores", LocalDateTime.of(2010, 5, 17, 12, 16, 17), "La Industria Inc", Arrays.asList(songs[1], songs[3])),
        };
        albumRepository.saveAll(Arrays.asList(albums));
    }

    public void deleteAll() {
        this.albumRepository.deleteAll();
        this.artistRepository.deleteAll();
        this.musicGenreRepository.deleteAll();
    }
}
