package es.upm.miw.apaw_practice.adapters.rest.hotel;

import es.upm.miw.apaw_practice.adapters.mongodb.hotel.HotelSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

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
}
