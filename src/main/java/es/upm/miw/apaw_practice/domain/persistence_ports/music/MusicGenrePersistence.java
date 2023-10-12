package es.upm.miw.apaw_practice.domain.persistence_ports.music;

import es.upm.miw.apaw_practice.domain.models.music.MusicGenre;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicGenrePersistence {

    MusicGenre create(MusicGenre musicGenre);
    boolean existsMusicGenreType(String type);
}
