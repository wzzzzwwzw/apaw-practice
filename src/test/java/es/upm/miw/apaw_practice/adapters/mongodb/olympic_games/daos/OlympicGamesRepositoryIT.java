package es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.entities.OlympicGamesEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class OlympicGamesRepositoryIT {

    @Autowired
    private OlympicGamesRepository olympicGamesRepository;

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Test
    void testFindByEdition() {
        assertTrue(this.olympicGamesRepository.findByEdition(25).isPresent());
        OlympicGamesEntity olympicGames = this.olympicGamesRepository.findByEdition(25).get();
        assertEquals("Barcelona", olympicGames.getHostingPlace());
        assertEquals(LocalDate.of(1992,7,25), olympicGames.getStartDate());
        assertTrue(olympicGames.getSummerGames());
        assertEquals(4, olympicGames.getDisciplinesEntities().size());
        assertTrue(this.disciplineRepository.findByName("Athletics").isPresent());
        assertEquals(this.disciplineRepository.findByName("Athletics").get(), olympicGames.getDisciplinesEntities().get(0));
    }
}
