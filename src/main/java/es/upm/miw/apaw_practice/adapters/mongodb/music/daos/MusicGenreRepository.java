package es.upm.miw.apaw_practice.adapters.mongodb.music.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.MusicGenreEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MusicGenreRepository extends MongoRepository<MusicGenreEntity, String> {

    Optional<MusicGenreEntity> findByType(String type);
}
