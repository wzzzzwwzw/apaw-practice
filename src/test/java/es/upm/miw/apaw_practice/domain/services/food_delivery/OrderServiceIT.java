package es.upm.miw.apaw_practice.domain.services.food_delivery;


import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.food_delivery.Order;
import es.upm.miw.apaw_practice.domain.persistence_ports.food_delivery.OrderPersistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
class OrderServiceIT {

    @Autowired
    private OrderService orderService;

    @Test
    void testRead(){
        Order order = this.orderService.read(3);
        assertEquals(new BigDecimal("4.5"),order.getWeight());
        assertEquals("Cash",order.getPaymentMethod());
        assertEquals(false,order.getDelivered());
        assertNotNull(order.getTransport());
        assertNotNull(order.getRestaurant());


    }
}


