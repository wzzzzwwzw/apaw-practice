package es.upm.miw.apaw_practice.adapters.mongodb.conference.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@TestConfig
class AuthorRepositoryIT {
    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void testCreateAndRead() {
        Assertions.assertTrue(this.authorRepository.findAll().stream()
                .anyMatch(author ->
                        "Jorge".equals(author.getName()) &&
                        "Da Silva".equals(author.getSurname()) &&
                        "Mr.".equals(author.getHonorific())
        ));
    }
}
