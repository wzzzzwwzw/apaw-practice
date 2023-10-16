package es.upm.miw.apaw_practice.adapters.rest.subway;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import es.upm.miw.apaw_practice.domain.models.subway.Schedule;

import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
class ScheduleResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdate() {
        this.webTestClient
                .get()
                .uri(ScheduleResource.SCHEDULES)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Schedule.class)
                .value(schedules -> assertFalse(schedules.isEmpty()))
                .value(schedules -> assertEquals(4F, schedules.get(0).getFrequency()));


        this.webTestClient
                .patch()
                .uri(ScheduleResource.SCHEDULES)
                .bodyValue(5.0F)
                .exchange()
                .expectStatus().isOk();

        this.webTestClient
                .get()
                .uri(ScheduleResource.SCHEDULES)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Schedule.class)
                .value(articles -> assertFalse(articles.isEmpty()))
                .value(articles -> assertEquals(5F, articles.get(0).getFrequency()));

    }
}
