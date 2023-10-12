package es.upm.miw.apaw_practice.adapters.mongodb.music.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.music.daos.MusicGenreRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.MusicGenreEntity;
import es.upm.miw.apaw_practice.domain.models.music.MusicGenre;
import es.upm.miw.apaw_practice.domain.persistence_ports.music.MusicGenrePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("musicGenrePersistence")
public class MusicGenrePersistenceMongodb implements MusicGenrePersistence {

    private final MusicGenreRepository musicGenreRepository;

    @Autowired
    public MusicGenrePersistenceMongodb(MusicGenreRepository musicGenreRepository) {
        this.musicGenreRepository = musicGenreRepository;
    }

    @Override
    public MusicGenre create(MusicGenre musicGenre) {
        return this.musicGenreRepository
                .save(new MusicGenreEntity(musicGenre))
                .toMusicGenre();
    }

    @Override
    public boolean existsMusicGenreType(String type) {
        return this.musicGenreRepository
                .findByType(type)
                .isPresent();
    }
}
