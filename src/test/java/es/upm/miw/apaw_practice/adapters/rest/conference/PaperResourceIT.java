package es.upm.miw.apaw_practice.adapters.rest.conference;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.conference.Paper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class PaperResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testRead() {
        this.webTestClient
                .get()
                .uri(PaperResource.PAPERS + PaperResource.DIGITAL_OBJECT_IDENTIFIER_ID, "DOI 1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Paper.class)
                .value(Assertions::assertNotNull)
                .value(paperData -> {
                    Assertions.assertEquals("Paper 1", paperData.getTitle());
                    Assertions.assertEquals(2, paperData.getAuthors().size());
                    Assertions.assertEquals("Jorge", paperData.getAuthors().get(0).getName());
                });
    }

    @Test
    void testReadNotFound() {
        this.webTestClient
                .get()
                .uri(PaperResource.PAPERS + PaperResource.DIGITAL_OBJECT_IDENTIFIER_ID, "DOI NAN")
                .exchange()
                .expectStatus().isNotFound();
    }
}
