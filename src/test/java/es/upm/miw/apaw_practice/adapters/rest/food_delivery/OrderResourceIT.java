package es.upm.miw.apaw_practice.adapters.rest.food_delivery;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.food_delivery.Order;
import es.upm.miw.apaw_practice.domain.models.food_delivery.OrderPriceUpdating;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

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
                    assertEquals("PayPal",order.getPaymentMethod());
                });

    }

    @Test
    void testUpdatePrices(){
        List<OrderPriceUpdating> orderPriceUpdatingList = Arrays.asList(
                new OrderPriceUpdating(4, new BigDecimal("25.0")),
                new OrderPriceUpdating(5,new BigDecimal("37.0"))
        );
        this.webTestClient
                .patch()
                .uri(OrderResource.ORDERS)
                .body(BodyInserters.fromValue(orderPriceUpdatingList))
                .exchange()
                .expectStatus().isOk();

    }

    @Test
    void testUpdatePricesNotFound(){
        List<OrderPriceUpdating> orderPriceUpdatingList = Arrays.asList(
                new OrderPriceUpdating(0, new BigDecimal("89.0"))

        );
        this.webTestClient
                .patch()
                .uri(OrderResource.ORDERS)
                .body(BodyInserters.fromValue(orderPriceUpdatingList))
                .exchange()
                .expectStatus().isNotFound();

    }

}
