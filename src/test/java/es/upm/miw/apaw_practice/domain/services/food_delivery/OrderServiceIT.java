package es.upm.miw.apaw_practice.domain.services.food_delivery;


import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.food_delivery.Order;
import es.upm.miw.apaw_practice.domain.models.food_delivery.OrderPriceUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.food_delivery.OrderPersistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
class OrderServiceIT {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderPersistence orderPersistence;

    @Test
    void testRead(){
        Order order = this.orderService.read(3);
        assertEquals(new BigDecimal("4.5"),order.getWeight());
        assertEquals("Cash",order.getPaymentMethod());
        assertEquals(false,order.getDelivered());
        assertNotNull(order.getTransport());
        assertNotNull(order.getRestaurant());


    }

    @Test
    void testUpdatePrices(){
        List<OrderPriceUpdating> orderPriceUpdatingList = Arrays.asList(
                new OrderPriceUpdating(1, new BigDecimal("27.0"))
        );
        this.orderService.updatePrices(orderPriceUpdatingList.stream());
        assertEquals(new BigDecimal("27.0"),this.orderPersistence.read(1).getPrice());
    }
}


