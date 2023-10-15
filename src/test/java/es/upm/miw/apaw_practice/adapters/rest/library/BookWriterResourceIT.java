package es.upm.miw.apaw_practice.adapters.rest.library;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.library.BookWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
public class BookWriterResourceIT {
    @Autowired
    private WebTestClient webTestClient;
    @Test
    void testCreate(){
        BookWriter bookWriter =
                new BookWriter("Antonio Hidalgo","A. Hidalgo",1);
        this.webTestClient
                .post()
                .uri(BookWriterResource.BOOKWRITER)
                .body(BodyInserters.fromValue(bookWriter))
                .exchange()
                .expectStatus().isOk()
                .expectBody(BookWriter.class)
                .value(Assertions::assertNotNull);
    }

    @Test
    void testCreateConflict(){
        BookWriter bookWriter =
                new BookWriter("Echo", "San Mao", null);
        this.webTestClient
                .post()
                .uri(BookWriterResource.BOOKWRITER)
                .body(BodyInserters.fromValue(bookWriter))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }
}
