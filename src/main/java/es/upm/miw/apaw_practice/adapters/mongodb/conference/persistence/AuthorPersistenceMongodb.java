package es.upm.miw.apaw_practice.adapters.mongodb.conference.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.conference.daos.AuthorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.conference.entities.AuthorEntity;
import es.upm.miw.apaw_practice.domain.models.conference.Author;
import es.upm.miw.apaw_practice.domain.persistence_ports.conference.AuthorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("authorPersistence")
public class AuthorPersistenceMongodb implements AuthorPersistence {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorPersistenceMongodb(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author create(Author author) {
        return this.authorRepository
                .save(new AuthorEntity(author))
                .toAuthor();
    }
}
