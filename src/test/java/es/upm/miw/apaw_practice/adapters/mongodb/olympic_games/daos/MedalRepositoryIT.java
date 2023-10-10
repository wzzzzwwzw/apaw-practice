package es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.entities.CompetitorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class MedalRepositoryIT {

    @Autowired
    MedalRepository medalRepository;

    @Autowired
    CompetitorRepository competitorRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.competitorRepository.findByName("Lebron").isPresent());
        CompetitorEntity winner = this.competitorRepository.findByName("Lebron").get();
        assertTrue(this.medalRepository.findAll().stream()
                .anyMatch(medal ->
                        "Gold".equals(medal.getTier()) &&
                        medal.getId() != null &&
                        "Basketball".equals(medal.getCompetition()) &&
                        medal.getTeamMedal() &&
                        winner.equals(medal.getWinner())
                )
        );
    }
}
