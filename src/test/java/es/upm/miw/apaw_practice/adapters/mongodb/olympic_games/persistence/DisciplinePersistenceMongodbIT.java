package es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.OlympicGamesSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.daos.DisciplineRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class DisciplinePersistenceMongodbIT {

    @Autowired
    private DisciplinePersistenceMongodb disciplinePersistenceMongodb;
    @Autowired
    private OlympicGamesSeederService olympicGamesSeederService;
    @Autowired
    private DisciplineRepository disciplineRepository;

    @Test
    void testDelete() {
        this.disciplinePersistenceMongodb.delete("Judo");
        assertEquals(3, this.disciplineRepository.count());
        this.olympicGamesSeederService.reSeedDatabase();
    }
}
