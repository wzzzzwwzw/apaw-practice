package es.upm.miw.apaw_practice.domain.persistence_ports.conference;

import es.upm.miw.apaw_practice.domain.models.conference.Author;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface AuthorPersistence {
    Author create(Author author);

    Stream<Author> readAll();
}
