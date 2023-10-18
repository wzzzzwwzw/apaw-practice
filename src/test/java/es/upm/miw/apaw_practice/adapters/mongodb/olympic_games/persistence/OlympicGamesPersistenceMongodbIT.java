package es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.OlympicGamesSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.daos.DisciplineRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.olympic_games.OlympicGames;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class OlympicGamesPersistenceMongodbIT {

    @Autowired
    private  OlympicGamesPersistenceMongodb olympicGamesPersistence;
    @Autowired
    private DisciplineRepository disciplineRepository;
    @Autowired
    private OlympicGamesSeederService olympicGamesSeederService;

    @Test
    void testReadByEdition() {
        OlympicGames olympicGames = this.olympicGamesPersistence.readByEdition(25);
        assertEquals("Barcelona", olympicGames.getHostingPlace());
        assertEquals(LocalDate.of(1992,7,25), olympicGames.getStartDate());
        assertTrue(olympicGames.getSummerGames());
        assertEquals(4, olympicGames.getDisciplines().size());
        assertTrue(this.disciplineRepository.findByName("Athletics").isPresent());
        assertEquals(this.disciplineRepository.findByName("Athletics").get().toDiscipline().toString(), olympicGames.getDisciplines().get(0).toString());
    }

    @Test
    void testReadByEditionError() {
        assertThrows(NotFoundException.class, () -> this.olympicGamesPersistence.readByEdition(10));
    }

    @Test
    void testUpdateHostingPlace() {
        OlympicGames olympicGames = this.olympicGamesPersistence.updateHostingPlace(1, "Rome");
        assertEquals("Rome", olympicGames.getHostingPlace());
        assertEquals(LocalDate.of(1896,4,5), olympicGames.getStartDate());
        assertTrue(olympicGames.getSummerGames());
        assertEquals(2, olympicGames.getDisciplines().size());
        olympicGamesSeederService.reSeedDatabase();
    }

    @Test
    void testUpdateHostingPlaceError() {
        assertThrows(NotFoundException.class, () -> this.olympicGamesPersistence.updateHostingPlace(44, "Rome"));
    }
}
