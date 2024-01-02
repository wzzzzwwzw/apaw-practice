package es.upm.miw.apaw_practice.domain.services.music;

import es.upm.miw.apaw_practice.domain.models.music.Artist;
import es.upm.miw.apaw_practice.domain.persistence_ports.music.AlbumPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.music.ArtistPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ArtistService {

    private final ArtistPersistence artistPersistence;

    private final AlbumPersistence albumPersistence;

    @Autowired
    public ArtistService(ArtistPersistence artistPersistence, AlbumPersistence albumPersistence) {
        this.artistPersistence = artistPersistence;
        this.albumPersistence = albumPersistence;
    }

    public Artist updatePhoneNumber(String dni, Integer phoneNumber) {
        Artist artist = this.artistPersistence.readByDni(dni);
        artist.setPhoneNumber(phoneNumber);
        return this.artistPersistence.updatePhoneNumber(artist);
    }

    public Stream<Integer> getPhoneNumbersByTypeAndRecordLabel(String type, String recordLabel) {
        return this.albumPersistence.findAlbumsByRecordLabel(recordLabel)
                .flatMap(album -> album.getSongsList().stream())
                .filter(song -> song.getMusicGenre().getType().equals(type))
                .flatMap(song -> song.getArtistsList().stream())
                .map(Artist::getPhoneNumber);
    }
}
