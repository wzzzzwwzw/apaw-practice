package es.upm.miw.apaw_practice.adapters.rest.fruitshop;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.fruitShop.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.apaw_practice.adapters.rest.fruitshop.CustomerResource.CUSTOMERS;
import static es.upm.miw.apaw_practice.adapters.rest.fruitshop.CustomerResource.ID_CUSTOMER;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class CustomerResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testFindByIdCustomer() {
        this.webTestClient
                .get()
                .uri(CUSTOMERS + ID_CUSTOMER, 1)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Customer.class)
                .value(Assertions::assertNotNull)
                .value(customer -> {
                    assertEquals(1, customer.getIdCustomer());
                    assertEquals("688-576-678", customer.getPhone());
                    assertEquals("ada2@gmail.com", customer.getEmail());

                });

    }
}

