package es.upm.miw.apaw_practice.adapters.mongodb.conference.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.conference.Author;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@TestConfig
class AuthorPersistenceMongodbIT {
    @Autowired
    private AuthorPersistenceMongodb authorPersistence;

    @Test
    void testCreateAndRead() {
        Author author = new Author("New", "Author", "Ms.");
        this.authorPersistence.create(author);
        Optional<Author> authorBD = this.authorPersistence.readAll()
                .filter(author1 -> "New".equals(author1.getName()))
                .findFirst();
        Assertions.assertTrue(authorBD.isPresent());
        Assertions.assertEquals("New", authorBD.get().getName());
        Assertions.assertEquals("Author", authorBD.get().getSurname());
        Assertions.assertEquals("Ms.", authorBD.get().getHonorific());

    }
}
