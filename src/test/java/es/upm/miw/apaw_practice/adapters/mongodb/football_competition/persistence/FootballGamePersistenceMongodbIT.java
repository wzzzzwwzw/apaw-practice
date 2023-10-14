package es.upm.miw.apaw_practice.adapters.mongodb.football_competition.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@TestConfig
public class FootballGamePersistenceMongodbIT {
    @Autowired
    private FootballGamePersistenceMongodb footballGamePersistence;

    @Test
    public void testGetTotalBudgetByLocation() {
        BigDecimal totalBudget = this.footballGamePersistence.getTotalBudgetByLocation("Barcelona");

        assertNotNull(totalBudget);
        assertEquals(new BigDecimal("20499779.34"), totalBudget);
    }
}
