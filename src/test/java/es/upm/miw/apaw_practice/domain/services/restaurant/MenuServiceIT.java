package es.upm.miw.apaw_practice.domain.services.restaurant;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@TestConfig
public class MenuServiceIT {

    @Autowired
    MenuService menuService;

    @Test
    void testDelete() {
        this.menuService.delete("1");
    }

}
