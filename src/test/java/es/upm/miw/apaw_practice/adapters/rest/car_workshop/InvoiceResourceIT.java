package es.upm.miw.apaw_practice.adapters.rest.car_workshop;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class InvoiceResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete(){
        this.webTestClient
                .delete()
                .uri(InvoiceResource.INVOICES + InvoiceResource.PAID)
                .exchange()
                .expectStatus().isOk();
    }
}
