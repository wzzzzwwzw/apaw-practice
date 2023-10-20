package es.upm.miw.apaw_practice.domain.models.football_competition;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
class FootballPlayerIT {
    @Test
    void testFootballPlayerBuilder() {
        FootballPlayerBuilders.Name builder = FootballPlayer.builder();
        FootballPlayer player = builder
                .name("Federico López")
                .goals(10)
                .assists(15)
                .salary(new BigDecimal("12031312.25"))
                .team(new FootballTeam())
                .height((float)1.90)
                .build();

        assertNotNull(player);
        assertEquals(10, player.getGoals());
        assertEquals(15, player.getAssists());
        assertEquals(new BigDecimal("12031312.25"), player.getSalary());
        assertEquals((float)1.90, player.getHeight());
        assertNotNull(player.getTeam());
    }
}
