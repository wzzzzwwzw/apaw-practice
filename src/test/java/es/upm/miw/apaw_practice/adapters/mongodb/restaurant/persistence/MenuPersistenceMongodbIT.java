package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.restaurant.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class MenuPersistenceMongodbIT {

    @Autowired
    MenuPersistenceMongodb menuPersistence;

    @Test
    void testFindAllMenusByLastModificationThisMonth() {
        List<Menu> menus = menuPersistence.findAllMenusByLastModificationThisMonth();
        assertEquals(1, menus.size());
    }

}
