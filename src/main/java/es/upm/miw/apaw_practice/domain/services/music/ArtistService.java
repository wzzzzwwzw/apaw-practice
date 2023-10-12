package es.upm.miw.apaw_practice.domain.services.music;

import es.upm.miw.apaw_practice.domain.models.music.Artist;
import es.upm.miw.apaw_practice.domain.persistence_ports.music.ArtistPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

    private final ArtistPersistence artistPersistence;

    @Autowired
    public ArtistService(ArtistPersistence artistPersistence) {
        this.artistPersistence = artistPersistence;
    }

    public Artist updatePhoneNumber(String dni, Integer phoneNumber) {
        Artist artist = this.artistPersistence.readByDni(dni);
        artist.setPhoneNumber(phoneNumber);
        return this.artistPersistence.updatePhoneNumber(artist);
    }
}
