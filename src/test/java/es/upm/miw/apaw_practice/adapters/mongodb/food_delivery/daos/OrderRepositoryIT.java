package es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.entities.OrderEntity;
import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestConfig
public class OrderRepositoryIT {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void testFindByNumber() {
        assertTrue(this.orderRepository.findByNumber(3).isPresent());
        OrderEntity order = this.orderRepository.findByNumber(3).get();
        assertEquals("Cash", order.getPaymentMethod());
        assertEquals(false, order.getDelivered());
        assertEquals(0, new BigDecimal("40.0").compareTo(order.getPrice()));
        assertEquals(0, new BigDecimal("4.5").compareTo(order.getWeight()));
        assertEquals("Burger Haven", order.getRestaurant().getName());
        assertEquals("T002", order.getTransport().getCode());

    }
}

