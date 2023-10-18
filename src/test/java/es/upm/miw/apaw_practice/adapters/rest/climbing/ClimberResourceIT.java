package es.upm.miw.apaw_practice.adapters.rest.climbing;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.climbing.Climber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

import static es.upm.miw.apaw_practice.adapters.rest.climbing.ClimberResource.CLIMBERS;
import static es.upm.miw.apaw_practice.adapters.rest.climbing.ClimberResource.EMAIL_ID;
import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
class ClimberResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadByEmail() {
        this.webTestClient
                .get()
                .uri(CLIMBERS + EMAIL_ID, "climber1@email.com")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Climber.class)
                .value(Assertions::assertNotNull)
                .value(climberData -> {
                    assertEquals("climber1@email.com", climberData.getEmail());
                    assertEquals(LocalDate.of(1990, 1, 1), climberData.getDateOfBirth());
                    assertEquals("Beginner", climberData.getLevel());
                    assertEquals(2, climberData.getExpeditions().size());
                    assertEquals(LocalDate.now(), climberData.getExpeditions().get(0).getDate());
                    assertEquals("1500.00", climberData.getExpeditions().get(0).getTotalExpense().toString());
                });
    }

    @Test
    void testReadByEmailNotFound() {
        this.webTestClient
                .get()
                .uri(CLIMBERS + EMAIL_ID, "nonexistent@email.com")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(CLIMBERS + EMAIL_ID, "climber2@email.com")
                .exchange()
                .expectStatus().isOk();
    }
}
