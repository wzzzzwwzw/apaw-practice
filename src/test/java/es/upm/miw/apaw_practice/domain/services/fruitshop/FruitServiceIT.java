package es.upm.miw.apaw_practice.domain.services.fruitshop;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.fruitShop.Fruit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class FruitServiceIT {
    @Autowired
    private FruitService fruitService;


    @Test
    void testUpdate() {
        BigDecimal unitPrice = new BigDecimal("6.6");
        BigDecimal newUnitPrice = unitPrice.add(new BigDecimal("1"));
        String type = "Apple";
        Fruit fruitChangeUnitPrice = fruitService.updateUnitPrice(type, newUnitPrice);
        assertNotNull(fruitChangeUnitPrice);
        assertEquals(type, fruitChangeUnitPrice.getType());
        assertEquals(newUnitPrice, fruitChangeUnitPrice.getUnitPrice());

    }
}
