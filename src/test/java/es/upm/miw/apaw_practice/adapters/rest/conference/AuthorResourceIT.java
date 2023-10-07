package es.upm.miw.apaw_practice.adapters.rest.conference;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.conference.Author;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
class AuthorResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        Author author = new Author("Alejandro", "Calleja", "Dr.");
        this.webTestClient.post().uri(AuthorResource.AUTHORS)
                .body(BodyInserters.fromValue(author))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Author.class)
                .value(Assertions::assertNotNull);
    }
}
