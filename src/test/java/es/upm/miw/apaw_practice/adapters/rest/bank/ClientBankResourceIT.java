package es.upm.miw.apaw_practice.adapters.rest.bank;


import es.upm.miw.apaw_practice.adapters.mongodb.bank.BankSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;

import es.upm.miw.apaw_practice.domain.models.bank.ClientBank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;


import java.util.List;

import static es.upm.miw.apaw_practice.adapters.rest.bank.ClientBankResource.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
public class ClientBankResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private BankSeederService bankSeederService;

    @AfterEach
    void resetDataBase() {
        this.bankSeederService.deleteAll();
        this.bankSeederService.seedDatabase();
    }
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

    @Test
    void testFindTypeNamesByDni(){
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(CLIENTS+SEARCH)
                        .queryParam("dni","23456789D")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class)
                .value(Assertions::assertNotNull)
                .value(typeList -> {
                    assertTrue(typeList.contains("Banco de Inversión"));
                    assertTrue(typeList.contains("Banco Comercial"));
                    assertEquals(2,typeList.size());
                });

    }

    @Test
    void testFindTypeNamesByDniNoDuplicated(){
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(CLIENTS+SEARCH)
                        .queryParam("dni","87654321B")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class)
                .value(Assertions::assertNotNull)
                .value(typeList -> {
                    assertTrue(typeList.contains("Banco de Inversión"));
                    assertEquals(1,typeList.size());
                });


    }

    @Test
    void testFindTypeNamesByDniNotFound(){
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(CLIENTS+SEARCH)
                        .queryParam("dni","243443R")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class)
                .value(Assertions::assertNotNull)
                .value(typeList -> {
                    assertEquals(0,typeList.size());
                });
    }
}
