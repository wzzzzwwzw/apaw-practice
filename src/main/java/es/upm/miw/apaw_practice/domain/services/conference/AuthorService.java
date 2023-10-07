package es.upm.miw.apaw_practice.domain.services.conference;

import es.upm.miw.apaw_practice.domain.models.conference.Author;
import es.upm.miw.apaw_practice.domain.models.shop.Article;
import es.upm.miw.apaw_practice.domain.persistence_ports.conference.AuthorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AuthorService {
    private final AuthorPersistence authorPersistence;

    @Autowired
    public AuthorService(AuthorPersistence authorPersistence) {
        this.authorPersistence = authorPersistence;
    }

    public Author create(Author author) {
        return this.authorPersistence.create(author);
    }
}
