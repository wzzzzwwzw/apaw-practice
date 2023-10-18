package es.upm.miw.apaw_practice.adapters.rest.bank;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;

import es.upm.miw.apaw_practice.domain.models.bank.Bank;


import es.upm.miw.apaw_practice.domain.models.bank.BankType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.time.LocalDate;


import static es.upm.miw.apaw_practice.adapters.rest.bank.BankResource.BANKS;
import static es.upm.miw.apaw_practice.adapters.rest.bank.BankResource.BANK_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class BankResourceIT {

    @Autowired
    private WebTestClient webTestClient;


    @Test
    void testRead() {
        this.webTestClient
                .get()
                .uri(BANKS+BANK_NAME,"DreamBank")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Bank.class)
                .value(Assertions::assertNotNull)
                .value(bank -> {
                    assertEquals("DreamBank", bank.getBankName());
                    assertEquals("Vigo", bank.getLocation());
                    assertEquals(new BigDecimal("6500000.00"), bank.getCapital());
                    assertEquals(3,bank.getListAccounts().size());
                });
    }

    @Test
    void testReadNotFound() {
        this.webTestClient
                .get()
                .uri(BANKS+BANK_NAME,"BANKIA")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testPostBank() {
        BankType bankType= new BankType("Auxiliar","Ayuda a la creación de más entidades",new BigDecimal("12000000.00"));
        Bank newBank = new Bank("IMPERIA","Cordoba", new BigDecimal("12000000.00"),bankType);
        this.webTestClient
                .post()
                .uri(BANKS)
                .body(BodyInserters.fromValue(newBank))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Bank.class)
                .value(Assertions::assertNotNull)
                .value(bank -> {
                    assertEquals(bank.getBankName(), newBank.getBankName());
                    assertEquals(bank.getCapital(),newBank.getCapital());
                    assertEquals(bank.getLocation(),newBank.getLocation());
                    assertEquals(bank.getListAccounts().size(),newBank.getListAccounts().size());
                });
    }

}
