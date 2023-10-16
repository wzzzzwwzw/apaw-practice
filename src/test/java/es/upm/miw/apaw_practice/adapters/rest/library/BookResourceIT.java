package es.upm.miw.apaw_practice.adapters.rest.library;

import es.upm.miw.apaw_practice.adapters.mongodb.library.LibrarySeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
class BookResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private LibrarySeederService librarySeederService;
    @AfterEach
    void cleanUpDB(){
        this.librarySeederService.deleteAll();
        this.librarySeederService.seedDatabase();
    }

    @Test
    void testDeleteEndPoint(){
        this.webTestClient
                .delete()
                .uri(BookResource.BOOKS + BookResource.ISBN_ID, "9788466659734")
                .exchange()
                .expectStatus().isOk();
    }
}
