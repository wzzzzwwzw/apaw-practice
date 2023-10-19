package es.upm.miw.apaw_practice.adapters.rest.hotel;

import es.upm.miw.apaw_practice.adapters.mongodb.hotel.HotelSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelActivity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class HotelActivityResourceIT {
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
    void testUpdateInstructor() {
        this.webTestClient
                .patch()
                .uri(HotelResource.HOTELS + HotelActivityResource.ACTIVITIES + HotelActivityResource.ACTIVITY_NAME, "Surf")
                .body(BodyInserters.fromValue("Elena"))
                .exchange()
                .expectStatus().isOk()
                .expectBody(HotelActivity.class)
                .value(Assertions::assertNotNull)
                .value(activity -> {
                    assertEquals(activity.getName(), "Surf");
                    assertEquals(activity.getInstructor(), "Elena");
                    assertEquals(activity.getMaxParticipants(), 10);
                    assertEquals(activity.getSchedule(), "M 10:00, J 10:00");
                });
    }

}
