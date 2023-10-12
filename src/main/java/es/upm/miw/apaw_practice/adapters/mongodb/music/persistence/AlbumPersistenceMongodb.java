package es.upm.miw.apaw_practice.adapters.mongodb.music.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.music.daos.AlbumRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.music.Song;
import es.upm.miw.apaw_practice.domain.persistence_ports.music.AlbumPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.SongEntity;

import java.util.stream.Stream;

@Repository("albumPersistence")
public class AlbumPersistenceMongodb implements AlbumPersistence {

    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumPersistenceMongodb(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }


    @Override
    public Stream<Song> readSongsByAlbumDenomination(String denomination) {
        return this.albumRepository.findByDenomination(denomination)
                .orElseThrow(() -> new NotFoundException("Album denomination: " + denomination))
                .getSongsList().stream().map(SongEntity::toSong);
    }
}
