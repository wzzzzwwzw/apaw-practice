package es.upm.miw.apaw_practice.adapters.rest.library;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.library.BookWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
class BookWriterResourceIT {
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

    @Test
    void testUpdateNumberOfBook(){
        this.webTestClient
                .put()
                .uri(BookWriterResource.BOOKWRITER + BookWriterResource.NICKNAME_ID + BookWriterResource.NUMBER_OF_BOOK, "Cixin")
                .body(BodyInserters.fromValue(30))
                .exchange()
                .expectStatus().isOk()
                .expectBody(BookWriter.class)
                .value(Assertions:: assertNotNull)
                .value(bookWriter -> {
                    assertEquals("Cixin Liu", bookWriter.getName());
                    assertEquals("Cixin", bookWriter.getNickname());
                    assertEquals(30, bookWriter.getNumberOfBook());
                });
    }
}
