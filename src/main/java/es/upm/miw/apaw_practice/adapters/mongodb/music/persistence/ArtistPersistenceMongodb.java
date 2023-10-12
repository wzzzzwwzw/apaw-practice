package es.upm.miw.apaw_practice.adapters.mongodb.music.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.music.daos.ArtistRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.ArtistEntity;
import es.upm.miw.apaw_practice.domain.models.music.Artist;
import es.upm.miw.apaw_practice.domain.persistence_ports.music.ArtistPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import org.springframework.stereotype.Repository;

@Repository("artistPersistence")
public class ArtistPersistenceMongodb implements ArtistPersistence {

    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistPersistenceMongodb(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Artist updatePhoneNumber(Artist artist) {
        ArtistEntity artistEntity = this.artistRepository
                .findByDni(artist.getDni())
                .orElseThrow(() -> new NotFoundException("Artist dni: " + artist.getDni()));
        artistEntity.setPhoneNumber(artist.getPhoneNumber());
        return this.artistRepository.save(artistEntity).toArtist();
    }

    @Override
    public Artist readByDni(String dni) {
        return this.artistRepository
                .findByDni(dni)
                .orElseThrow(() -> new NotFoundException("Artist dni: " + dni))
                .toArtist();
    }
}
