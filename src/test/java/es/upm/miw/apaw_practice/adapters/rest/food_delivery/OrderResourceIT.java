package es.upm.miw.apaw_practice.adapters.rest.food_delivery;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.food_delivery.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
class OrderResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testGetByName(){
        this.webTestClient
                .get()
                .uri(OrderResource.ORDERS+OrderResource.NUMBER_ID,2)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Order.class)
                .value(Assertions::assertNotNull)
                .value(order->{
                    assertEquals(true,order.getDelivered());
                    assertEquals(new BigDecimal("30.0"),order.getPrice());
                    assertEquals("PayPal",order.getPaymentMethod());
                });

    }

}
