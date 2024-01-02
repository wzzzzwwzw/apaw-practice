package es.upm.miw.apaw_practice.adapters.rest.subway;


import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.subway.Station;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RestTestConfig
class StationResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadByName() {
        this.webTestClient
                .get()
                .uri(StationResource.STATIONS + StationResource.NAME_ID, "Canal")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Station.class)
                .value( station -> assertEquals("Canal", station.getName()) );
    }

    @Test
    void testCreateAndRead() {
        this.webTestClient
                .post()
                .uri(StationResource.STATIONS)
                .bodyValue(new Station("Opera", "RED-7#", true))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Station.class)
                .value(
                        station -> {
                            assertEquals("Opera", station.getName());
                        }
                );
        this.webTestClient
                .get()
                .uri(StationResource.STATIONS + StationResource.NAME_ID, "Opera")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Station.class)
                .value(
                        station -> {
                            assertEquals("Opera", station.getName());
                        }
                );
    }

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(StationResource.STATIONS + StationResource.NAME_ID, "Opera")
                .exchange()
                .expectStatus().isOk();
    }

}
