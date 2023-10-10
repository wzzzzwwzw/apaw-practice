package es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.daos;


import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.entities.DisciplineEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class DisciplineRepositoryIT {

    @Autowired
    DisciplineRepository disciplineRepository;

    @Autowired
    CompetitorRepository competitorRepository;

    @Test
    void testFindByName() {
        assertTrue(this.disciplineRepository.findByName("Judo").isPresent());
        DisciplineEntity discipline = this.disciplineRepository.findByName("Judo").get();
        assertEquals(14, discipline.getNumberOfCompetitions());
        assertEquals(LocalDate.of(1964, 4, 10), discipline.getAdditionDate());
        assertTrue(this.competitorRepository.findByName("Marco").isPresent());
        assertEquals(this.competitorRepository.findByName("Marco").get(), discipline.getCompetitorEntities().get(0));
    }
}
