package es.upm.miw.apaw_practice.domain.services.music;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.music.MusicGenre;
import es.upm.miw.apaw_practice.domain.persistence_ports.music.MusicGenrePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicGenreService {

    private final MusicGenrePersistence musicGenrePersistence;

    @Autowired
    public MusicGenreService(MusicGenrePersistence musicGenrePersistence) {
        this.musicGenrePersistence = musicGenrePersistence;
    }

    public MusicGenre create(MusicGenre musicGenre) {
        this.assertMusicGenreTypeNotExists(musicGenre.getType());
        return this.musicGenrePersistence.create(musicGenre);
    }

    private void assertMusicGenreTypeNotExists(String type) {
        if (this.musicGenrePersistence.existsMusicGenreType(type)) {
            throw new ConflictException("MusicGenre type already exists: " + type);
        }
    }

    public MusicGenre updatePopularityByType(String type) {
        return this.musicGenrePersistence.updatePopularityByType(type);
    }
}
