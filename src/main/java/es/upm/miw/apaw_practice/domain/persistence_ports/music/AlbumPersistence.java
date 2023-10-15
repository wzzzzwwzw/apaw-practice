package es.upm.miw.apaw_practice.domain.persistence_ports.music;

import es.upm.miw.apaw_practice.domain.models.music.Song;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface AlbumPersistence {

    Stream<Song> readSongsByAlbumDenomination(String denomination);

    void delete(String denomination);
}
