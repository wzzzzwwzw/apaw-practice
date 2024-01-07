package es.upm.miw.apaw_practice.domain.services.padel_academy;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.PadelAcademySeederService;
import es.upm.miw.apaw_practice.domain.models.padel_academy.Academy;
import es.upm.miw.apaw_practice.domain.models.padel_academy.Tournament;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class TournamentServiceIT {
    @Autowired
    private TournamentService tournamentService;
    @Autowired
    private AcademyService academyService;
    @Autowired
    private PadelAcademySeederService padelAcademySeederService;

    @AfterEach
    void resetDatabase() {
        this.padelAcademySeederService.deleteAll();
        this.padelAcademySeederService.seedDatabase();
    }

    @Test
    void testCreate() {
        Academy academy = this.academyService.read("La Masó Sports Club");
        Tournament tournament = this.tournamentService.create(
                new Tournament("Torneo Padel Fever", new BigDecimal("100.00"),  LocalDate.of(2024, 11, 1), academy)
        );

        assertNotNull(academy);
        assertNotNull(tournament);
        assertEquals("Torneo Padel Fever", tournament.getTitle());
        assertEquals(new BigDecimal("100.00"), tournament.getPrize());
        assertEquals(LocalDate.of(2024, 11, 1), tournament.getSchedule());

    }
}
