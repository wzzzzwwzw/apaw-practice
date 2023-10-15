package es.upm.miw.apaw_practice.domain.services.fruitshop;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@TestConfig
public class FruitShopServiceIT {
    @Autowired
    private  FruitShopService fruitShopService;

    @Test
    void testDelete() {
        fruitShopService.delete("Fruitful Delights");
    }
}
