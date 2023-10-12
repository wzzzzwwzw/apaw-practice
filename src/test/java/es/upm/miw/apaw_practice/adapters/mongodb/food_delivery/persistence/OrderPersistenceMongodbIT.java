package es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.persistence;


import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.food_delivery.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class OrderPersistenceMongodbIT {

    @Autowired
    private OrderPersistenceMongodb orderPersistence;

    @Test
    void testReadNotFound() {
        assertThrows(NotFoundException.class, () -> this.orderPersistence.read(8));
    }

    @Test
    void testReadFound() {
        assertNotNull(this.orderPersistence.read(1));
    }

    @Test
    void testUpdate() {
        Order order = this.orderPersistence.read(2);
        order.setPrice(new BigDecimal("45.0"));
        this.orderPersistence.update(2, order);
        order = this.orderPersistence.read(2);
        assertEquals(new BigDecimal("45.0"), order.getPrice());
    }

    @Test
    void testFindByTypeRestaurant(){
        BigDecimal sum = this.orderPersistence.findByTypeRestaurant("Italian");
        //assertEquals(new BigDecimal("97.0"),sum);
    }


}
