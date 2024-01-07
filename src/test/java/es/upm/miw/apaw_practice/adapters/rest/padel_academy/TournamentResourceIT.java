package es.upm.miw.apaw_practice.adapters.rest.padel_academy;

import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.PadelAcademySeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.padel_academy.Academy;
import es.upm.miw.apaw_practice.domain.models.padel_academy.Tournament;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class TournamentResourceIT {
    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private PadelAcademySeederService padelAcademySeederService;

    @AfterEach
    void resetDatabase() {
        this.padelAcademySeederService.deleteAll();
        this.padelAcademySeederService.seedDatabase();
    }

    @Test
    void testCreate() {
        this.webTestClient
                .get()
                .uri(AcademyResource.ACADEMIES + AcademyResource.NAME, "Ocio y Deporte Canal")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Academy.class)
                .value(Assertions::assertNotNull)
                .value(academy -> {
                    Tournament newTournament = new Tournament("Torneo Padel Fever", new BigDecimal("100.00"),  LocalDate.of(2024, 11, 1), academy);
                    this.webTestClient
                            .post()
                            .uri(TournamentResource.TOURNAMENTS)
                            .body(BodyInserters.fromValue(newTournament))
                            .exchange()
                            .expectStatus().isOk()
                            .expectBody(Tournament.class)
                            .value(tournament -> {
                                assertEquals("Torneo Padel Fever", tournament.getTitle());
                                assertEquals(new BigDecimal("100.00"), tournament.getPrize());
                                assertEquals(LocalDate.of(2024, 11, 1), tournament.getSchedule());
                            });
                });
    }
}
