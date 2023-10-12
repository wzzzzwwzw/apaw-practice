package es.upm.miw.apaw_practice.adapters.rest.conference;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.conference.Paper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
class PaperResourceIT {
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

    @Test
    void testUpdate() {
        String title = "New title for paper 1";

        this.webTestClient
                .put()
                .uri(PaperResource.PAPERS + PaperResource.DIGITAL_OBJECT_IDENTIFIER_ID + PaperResource.PAPER_TITLE, "DOI 1")
                .body(BodyInserters.fromValue(title))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Paper.class)
                .value(Assertions::assertNotNull)
                .value(paper -> Assertions.assertEquals(title, paper.getTitle()));
    }

    @Test
    void testUpdateNotFound() {
        String title = "New title for paper 1";

        this.webTestClient
                .put()
                .uri(PaperResource.PAPERS + PaperResource.DIGITAL_OBJECT_IDENTIFIER_ID + PaperResource.PAPER_TITLE, "DOI NaN")
                .body(BodyInserters.fromValue(title))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testFindTotalLengthByConferenceLocationHall() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(PaperResource.PAPERS + PaperResource.SEARCH)
                                .queryParam("q", "hall:Main hall")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(Integer.class)
                .value(length -> Assertions.assertEquals(26, length));
    }

    @Test
    void testFindTotalLengthByConferenceLocationHallNotExistingHall() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(PaperResource.PAPERS + PaperResource.SEARCH)
                                .queryParam("q", "hall:Bad hall")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(Integer.class)
                .value(length -> Assertions.assertEquals(0, length));
    }

    @Test
    void testFindTotalLengthByConferenceLocationHallBadRequest() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(PaperResource.PAPERS + PaperResource.SEARCH)
                                .queryParam("q", "hal:Main hall")
                                .build())
                .exchange()
                .expectStatus().isBadRequest();
    }
}
