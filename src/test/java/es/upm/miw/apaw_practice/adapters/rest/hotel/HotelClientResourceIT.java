package es.upm.miw.apaw_practice.adapters.rest.hotel;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelActivity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class HotelClientResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDeleteClient() {
        this.webTestClient
                .delete()
                .uri(HotelResource.HOTELS + HotelClientResource.CLIENTS + HotelClientResource.CLIENT_DNI, "11122233B")
                .exchange()
                .expectStatus().isOk();
    }
}
