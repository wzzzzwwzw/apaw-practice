package es.upm.miw.apaw_practice.domain.services.olympic_games;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.OlympicGamesSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.daos.DisciplineRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class DisciplineServiceIT {

    @Autowired
    private DisciplineService disciplineService;
    @Autowired
    private OlympicGamesSeederService olympicGamesSeederService;
    @Autowired
    private DisciplineRepository disciplineRepository;

    @Test
    void testDelete() {
        this.disciplineService.delete("Judo");
        assertEquals(3, this.disciplineRepository.count());
        this.olympicGamesSeederService.reSeedDatabase();
    }

}
