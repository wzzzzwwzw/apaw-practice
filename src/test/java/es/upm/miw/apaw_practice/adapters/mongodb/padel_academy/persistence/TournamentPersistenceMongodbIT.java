package es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.padel_academy.PadelAcademySeederService;
import es.upm.miw.apaw_practice.domain.models.padel_academy.Academy;
import es.upm.miw.apaw_practice.domain.models.padel_academy.Tournament;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class TournamentPersistenceMongodbIT {
    @Autowired
    private TournamentPersistenceMongodb tournamentPersistenceMongodb;
    @Autowired AcademyPersistenceMongodb academyPersistenceMongodb;
    @Autowired
    private PadelAcademySeederService padelAcademySeederService;

    @AfterEach
    void resetDatabase() {
        this.padelAcademySeederService.deleteAll();
        this.padelAcademySeederService.seedDatabase();
    }

    @Test
    void testCreate() {
        Academy academy = this.academyPersistenceMongodb.readByName("La Masó Sports Club");
        Tournament tournament = this.tournamentPersistenceMongodb.create(
                new Tournament("Torneo Padel Fever", new BigDecimal("100.00"),  LocalDate.of(2024, 11, 1), academy)
        );

        assertNotNull(academy);
        assertNotNull(tournament);
        assertEquals("Torneo Padel Fever", tournament.getTitle());
        assertEquals(new BigDecimal("100.00"), tournament.getPrize());
        assertEquals(LocalDate.of(2024, 11, 1), tournament.getSchedule());
    }

    @Test
    void testReadAll() {
        Stream<Tournament> tournaments =  this.tournamentPersistenceMongodb.readAll();
        assertEquals(4, tournaments.count());
    }
}
