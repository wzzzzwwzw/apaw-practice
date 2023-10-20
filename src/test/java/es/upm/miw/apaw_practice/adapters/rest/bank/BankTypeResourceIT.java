package es.upm.miw.apaw_practice.adapters.rest.bank;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.BankSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.bank.BankType;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

import static es.upm.miw.apaw_practice.adapters.rest.bank.BankTypeResource.*;

import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
public class BankTypeResourceIT {

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
                .uri(TYPES+TYPE_NAME,"Banco Cooperativo")
                .exchange()
                .expectStatus().isOk()
                .expectBody(BankType.class)
                .value(Assertions::assertNotNull)
                .value(bankType -> {
                    assertEquals("Banco Cooperativo", bankType.getTypeName());
                    assertEquals("Banco que es propiedad de sus miembros y opera con principios cooperativos.", bankType.getDescription());
                    assertEquals(new BigDecimal("30000000.00"), bankType.getMinimunCapital());
                });
    }

    @Test
    void testReadNotFound() {
        this.webTestClient
                .get()
                .uri(TYPES+TYPE_NAME,"Generador")
                .exchange()
                .expectStatus().isNotFound();
    }

}
