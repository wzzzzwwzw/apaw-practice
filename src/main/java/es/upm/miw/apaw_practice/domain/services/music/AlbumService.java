package es.upm.miw.apaw_practice.domain.services.music;

import es.upm.miw.apaw_practice.domain.models.music.Song;
import es.upm.miw.apaw_practice.domain.persistence_ports.music.AlbumPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class AlbumService {

    private final AlbumPersistence albumPersistence;

    @Autowired
    public AlbumService(AlbumPersistence albumPersistence) {
        this.albumPersistence = albumPersistence;
    }

    public Stream<Song> readSongsByAlbumDenomination(String denomination) {
        return this.albumPersistence.readSongsByAlbumDenomination(denomination);
    }
}
