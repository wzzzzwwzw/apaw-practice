package es.upm.miw.apaw_practice.domain.services.basketball;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.BasketballSeederService;
import es.upm.miw.apaw_practice.domain.models.basketball.Pavilion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@TestConfig
class PavilionServiceIT {
    @Autowired
    private PavilionService pavilionService;
    @Autowired
    private BasketballSeederService basketballSeederService;
    @BeforeEach
    void resetDataBase() {
        this.basketballSeederService.deleteAll();
        this.basketballSeederService.seedDatabase();
    }
    @Test
    void testCreatePavilion() {
        Pavilion pavilion = this.pavilionService.create(new Pavilion.Builder()
                .pavname("pavilion3")
                .direction("location1")
                .capacity(40)
                .build());
        assertNotNull(pavilion);
        assertEquals("pavilion3", pavilion.getPavname());
        assertEquals("location1", pavilion.getDirection());
        assertEquals(40, pavilion.getCapacity());
    }

    @Test
    void testFindAvgOfTotalCapacityByBasketValue() {
        assertEquals(0, new BigDecimal("1500").compareTo(this.pavilionService.findAvgOfTotalCapacityByBasketValue(3)));
        assertEquals(0, new BigDecimal("1500").compareTo(this.pavilionService.findAvgOfTotalCapacityByBasketValue(2)));
        assertEquals(0, new BigDecimal("0").compareTo(this.pavilionService.findAvgOfTotalCapacityByBasketValue(1)));
    }
}
