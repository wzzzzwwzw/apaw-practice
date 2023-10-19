package es.upm.miw.apaw_practice.adapters.rest.subway;

import es.upm.miw.apaw_practice.adapters.mongodb.subway.SubwaySeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.subway.Line;
import es.upm.miw.apaw_practice.domain.models.subway.Subway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
class SubwayResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private SubwaySeederService subwaySeederService;

    @BeforeEach
    void resetDataBase() {
        this.subwaySeederService.deleteAll();
        this.subwaySeederService.seedDatabase();
    }

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

    @Test
    void testPutLine() {

        Subway subway = this.webTestClient
                .get()
                .uri(SubwayResource.SUBWAYS + SubwayResource.CITY_ID, "Madrid")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Subway.class)
                .returnResult().getResponseBody();

        subway.getLines().get(0).setLabel("Blue Line");

        this.webTestClient
                .put()
                .uri(SubwayResource.SUBWAYS + SubwayResource.CITY_ID + SubwayResource.LINES, "Madrid")
                .bodyValue(subway.getLines())
                .exchange()
                .expectStatus().isOk()
                .expectBody(Subway.class)
                .value(newSubway -> assertEquals("Blue Line", newSubway.getLines().get(0).getLabel()));
    }

    @Test
    void testFindCapacityOverTen() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(SubwayResource.SUBWAYS + SubwayResource.SEARCH)
                        .queryParam("order", "RED-2#ORANGE-2")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class)
                .value(colors -> assertTrue(colors.contains("RED")));
    }

}
