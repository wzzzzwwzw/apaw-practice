package es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.entities.TournamentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class TournamentRepositoryIT {
    @Autowired
    TournamentRepository tournamentRepository;

    @Test
    void testFindByTitle() {
        assertTrue(this.tournamentRepository.findByTitle("Torneo Padel Fever").isPresent());
        TournamentEntity tournament = this.tournamentRepository.findByTitle("Torneo Padel Fever").get();
        assertEquals(new BigDecimal("100.00"), tournament.getPrize());
        assertEquals(LocalDate.of(2023, 11, 1), tournament.getSchedule());
    }
}
