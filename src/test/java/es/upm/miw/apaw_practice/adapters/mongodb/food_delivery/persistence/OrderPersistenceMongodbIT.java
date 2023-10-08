package es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.persistence;


import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
class OrderPersistenceMongodbIT {

    @Autowired
    private OrderPersistenceMongodb orderPersistence;

    @Test
    void testReadNotFound() {
        assertThrows(NotFoundException.class, () -> this.orderPersistence.read(8));
    }

    @Test
    void testReadFound(){
        assertNotNull(this.orderPersistence.read(1));
    }



}
