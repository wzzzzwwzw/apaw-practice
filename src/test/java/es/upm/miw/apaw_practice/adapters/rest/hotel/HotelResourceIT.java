package es.upm.miw.apaw_practice.adapters.rest.hotel;

import es.upm.miw.apaw_practice.adapters.mongodb.hotel.HotelSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.hotel.Hotel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
class HotelResourceIT {
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
    void testGetByName() {
        this.webTestClient
                .get()
                .uri(HotelResource.HOTELS + HotelResource.HOTEL_NAME, "Diamond")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Hotel.class)
                .value(Assertions::assertNotNull)
                .value(hotel -> {
                    assertEquals("Diamond", hotel.getName());
                    assertEquals(5, hotel.getStars());
                    assertEquals(700, hotel.getRooms());
                    assertNotNull(hotel.getBookings());
                    assertNotNull(hotel.getActivities());
                });
    }

    @Test
    void testGetMaxParticipantsSumByEmail(){
        this.webTestClient.
                get().uri(uriBuilder ->
                        uriBuilder.path(HotelResource.HOTELS + HotelResource.SEARCH_MAX_PARTICIPANTS)
                                .queryParam("q", "email:first@email.com")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(Double.class)
                .value(Assertions::assertNotNull).
                isEqualTo(15.6);
    }

    @Test
    void testGetRoomsNumberByInstructor(){
        this.webTestClient.
                get().uri(uriBuilder ->
                        uriBuilder.path(HotelResource.HOTELS + HotelResource.SEARCH_ROOMS_NUMBERS)
                                .queryParam("q", "instructorName:Adam")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class)
                .value(Assertions::assertNotNull).isEqualTo(Arrays.asList(700, 1000, 400));
    }

}
