package es.upm.miw.apaw_practice.adapters.rest.subway;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.subway.Line;
import es.upm.miw.apaw_practice.domain.models.subway.Subway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
class SubwayResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadByCity() {
        this.webTestClient
                .get()
                .uri(SubwayResource.SUBWAYS + SubwayResource.CITY_ID, "Madrid")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Subway.class)
                .value(subway -> assertEquals("Madrid", subway.getCity()));
    }

    @Test
    void testReadLineByCityByLabel() {
        this.webTestClient
                .get()
                .uri(SubwayResource.SUBWAYS + SubwayResource.CITY_ID + SubwayResource.LINES + SubwayResource.LABEL_ID, "Madrid", "Red Line")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Line.class)
                .value(line -> assertEquals("RED", line.getColor()));
    }



}
