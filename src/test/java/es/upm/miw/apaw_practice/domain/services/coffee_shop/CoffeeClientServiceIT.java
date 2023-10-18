package es.upm.miw.apaw_practice.domain.services.coffee_shop;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class CoffeeClientServiceIT {
    @Autowired
    private CoffeeClientService coffeeClientService;

    @Test
    void testGetTotalPriceByCategory() {
        BigDecimal totalPriceByCategory = this.coffeeClientService.getTotalPriceByCategory("Tea");
        assertEquals(new BigDecimal("60.00"), totalPriceByCategory);
    }

    @Test
    void testGetUniqueLocationsByCoffee() {
        List<String> uniqueLocationByCoffee = this.coffeeClientService.getUniqueLocationsByCoffee("Expresso Frappuccino");
        assertEquals(List.of("location4"), uniqueLocationByCoffee);
    }

}
