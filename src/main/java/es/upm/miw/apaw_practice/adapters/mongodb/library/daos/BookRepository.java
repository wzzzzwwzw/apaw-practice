package es.upm.miw.apaw_practice.adapters.mongodb.library.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.BookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookRepository extends MongoRepository<BookEntity, String> {
    Optional<BookEntity> findByIsbn(String isbn);
    int deleteByIsbn(String isbn);
}
