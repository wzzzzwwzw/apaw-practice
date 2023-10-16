package es.upm.miw.apaw_practice.adapters.mongodb.library.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.BookWriterEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookWriterRepository extends MongoRepository<BookWriterEntity, String> {
    Optional<BookWriterEntity> findByNickname(String nickname);
}
