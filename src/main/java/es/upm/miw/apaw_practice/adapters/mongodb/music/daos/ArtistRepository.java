package es.upm.miw.apaw_practice.adapters.mongodb.music.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.ArtistEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ArtistRepository extends MongoRepository<ArtistEntity, String> {

    Optional<ArtistEntity> findByDni(String dni);
}
