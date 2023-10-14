package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.football_competition.entities.FootballGameEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class FootballGameRepositoryIT {
    @Autowired
    private FootballGameRepository footballGameRepository;

    @Test
    void testFindByLocation() {
        String location = "Barcelona";
        assertTrue(this.footballGameRepository.findByLocation(location).isPresent());
        List<FootballGameEntity> games = this.footballGameRepository.findByLocation(location).get();

        assertTrue(games.size() > 1);
        assertTrue(games.stream().allMatch(g -> Objects.equals(g.getLocation(), location)));
    }
}
