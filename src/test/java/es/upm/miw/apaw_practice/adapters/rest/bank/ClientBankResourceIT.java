package es.upm.miw.apaw_practice.adapters.rest.bank;


import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;

import es.upm.miw.apaw_practice.domain.models.bank.ClientBank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;


import java.math.BigDecimal;

import static es.upm.miw.apaw_practice.adapters.rest.bank.ClientBankResource.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class ClientBankResourceIT {

    @Autowired
    private WebTestClient webTestClient;
    @Test
    void testRead() {
        this.webTestClient
                .get()
                .uri(CLIENTS+DNI,"12345678A")
                .exchange()
                .expectStatus().isOk()
                .expectBody(ClientBank.class)
                .value(Assertions::assertNotNull)
                .value(clientBank -> {
                    assertEquals("12345678A", clientBank.getDni());
                    assertEquals("Juan", clientBank.getClientName());
                });
    }
    @Test
    void testReadNotFound() {
        this.webTestClient
                .get()
                .uri(CLIENTS+DNI,"7754321B")
                .exchange()
                .expectStatus().isNotFound();
    }
    @Test
    void delete(){
        this.webTestClient.delete()
                .uri(CLIENTS + DNI, "87654321B")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void deleteNotFound(){
        this.webTestClient.delete()
                .uri(CLIENTS + DNI, "4f654321B")
                .exchange()
                .expectStatus().isNotFound();
    }
}
