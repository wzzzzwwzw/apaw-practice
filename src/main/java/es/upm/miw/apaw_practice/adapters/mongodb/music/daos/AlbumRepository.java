package es.upm.miw.apaw_practice.adapters.mongodb.music.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.AlbumEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AlbumRepository extends MongoRepository<AlbumEntity, String> {

    Optional<AlbumEntity> findByDenomination(String denomination);

    int deleteByDenomination(String denomination);
}
