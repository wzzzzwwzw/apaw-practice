package es.upm.miw.apaw_practice.adapters.rest.conference;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
class ConferenceLocationResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testPatchNotFound() {
        String hall = "New Hall";
        this.webTestClient.patch()
                .uri(ConferenceLocationResource.CONFERENCE_LOCATIONS + ConferenceLocationResource.ID_ID, "NaN")
                .body(BodyInserters.fromValue(hall))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testSearchFindCitiesByAuthorHonorific() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(ConferenceLocationResource.CONFERENCE_LOCATIONS + ConferenceLocationResource.SEARCH)
                                .queryParam("q", "honorific:Dr.")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .value(cities -> Assertions.assertFalse(cities.isEmpty()))
                .value(cities -> Assertions.assertTrue(cities.get(0).contains("Toulouse")))
                .value(cities -> Assertions.assertTrue(cities.get(0).contains("San Antonio")));
    }

    @Test
    void testSearchFindCitiesByAuthorHonorificBadRequest() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(ConferenceLocationResource.CONFERENCE_LOCATIONS + ConferenceLocationResource.SEARCH)
                                .queryParam("q", "honor:Dr.")
                                .build())
                .exchange()
                .expectStatus().isBadRequest();
    }
}
