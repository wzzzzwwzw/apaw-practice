package es.upm.miw.apaw_practice.adapters.mongodb.music.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.music.daos.AlbumRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.AlbumEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.SongEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.music.Album;
import es.upm.miw.apaw_practice.domain.models.music.Song;
import es.upm.miw.apaw_practice.domain.persistence_ports.music.AlbumPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    @Override
    public void delete(String denomination) {
        this.albumRepository.deleteByDenomination(denomination);
    }

    @Override
    public Stream<Album> findAlbumsByRecordLabel(String recordLabel) {
        return this.albumRepository.findAll()
                .stream()
                .filter(album -> album.getRecordLabel().equals(recordLabel))
                .map(AlbumEntity::toAlbum);
    }

    @Override
    public List<String> getDifferentDenominationsByFullname(String fullname) {
        return this.albumRepository.findAll()
                .stream()
                .filter(album -> album.getSongsList().stream()
                        .anyMatch(song -> song.getArtistsList().stream()
                                .anyMatch(artist -> artist.getFullName().equals(fullname))))
                .map(AlbumEntity::getDenomination)
                .distinct()
                .toList();
    }
}
