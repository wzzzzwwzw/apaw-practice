package es.upm.miw.apaw_practice.adapters.rest.hotel;

import es.upm.miw.apaw_practice.adapters.mongodb.hotel.HotelSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelActivity;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelClient;
import org.junit.jupiter.api.AfterEach;
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

    @Autowired
    private HotelSeederService hotelSeeder;

    @AfterEach
    public void resetDataBase() {
        this.hotelSeeder.deleteAll();
        this.hotelSeeder.seedDatabase();
    }

    @Test
    void testDeleteClient() {
        this.webTestClient
                .delete()
                .uri(HotelResource.HOTELS + HotelClientResource.CLIENTS + HotelClientResource.CLIENT_DNI, "11122233B")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testUpdateClient() {
        HotelClient clientUpdate = new HotelClient("11122233A","example@email.com",123123123,true);

        this.webTestClient
                .put()
                .uri(HotelResource.HOTELS + HotelClientResource.CLIENTS)
                .body(BodyInserters.fromValue(clientUpdate))
                .exchange()
                .expectStatus().isOk()
                .expectBody(HotelClient.class)
                .value(Assertions::assertNotNull)
                .value(clientUpdated -> {
                    assertEquals(clientUpdate.getDni(), clientUpdated.getDni());
                    assertEquals(clientUpdate.getTelephone(), clientUpdated.getTelephone());
                    assertEquals(clientUpdate.getEmail(), clientUpdated.getEmail());
                    assertEquals(clientUpdate.getPartnership(), clientUpdated.getPartnership());
                });
    }
}
