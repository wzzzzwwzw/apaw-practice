package es.upm.miw.apaw_practice.adapters.rest.hotel;

import es.upm.miw.apaw_practice.adapters.mongodb.hotel.HotelSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelBooking;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.time.LocalDate;


@RestTestConfig
public class HotelBookingResourceIT {
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
    void testCreateBooking() {
        HotelClient client = new HotelClient("11100033A", "example@email.com", 112222333, true);
        HotelBooking booking = new HotelBooking(10, 999, LocalDate.of(2023, 10, 21), new BigDecimal("49.99"), client);

        this.webTestClient
                .post()
                .uri(HotelResource.HOTELS + HotelBookingResource.BOOKINGS)
                .body(BodyInserters.fromValue(booking))
                .exchange()
                .expectStatus().isOk()
                .expectBody(HotelBooking.class)
                .value(Assertions::assertNotNull);
    }

}
