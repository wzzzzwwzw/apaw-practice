package es.upm.miw.apaw_practice.adapters.rest.bank;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.BankSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankTypeEntity;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;


import es.upm.miw.apaw_practice.domain.models.bank.Bank;


import es.upm.miw.apaw_practice.domain.models.bank.BankAccount;
import es.upm.miw.apaw_practice.domain.models.bank.BankType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;



import static es.upm.miw.apaw_practice.adapters.rest.bank.BankResource.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class BankResourceIT {

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


    @Test
    void testUpdateBank(){
        this.webTestClient
                .put()
                .uri(BANKS + BANK_NAME ,
                        "SrDell")
                .body(BodyInserters.fromValue(new Bank("SrDell","Huelva",new BigDecimal("99999999.99"),new BankType("Banco de Inversión", "Banco que se especializa en servicios de inversión y asesoramiento financiero.", new BigDecimal("10000000.00")))))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Bank.class)
                .value(Assertions::assertNotNull)
                .value(
                        bank -> {
                            assertEquals("Huelva",bank.getLocation());
                            assertEquals(new BigDecimal("99999999.99"), bank.getCapital());
                            assertEquals("Banco de Inversión",bank.getBankType().getTypeName());
                            assertEquals(0,bank.getListAccounts().size());
                        }
                );
    }

    @Test
    void testUpdateBankNotFound(){
        this.webTestClient
                .put()
                .uri(BANKS + BANK_NAME,
                        "TERESA")
                .body(BodyInserters.fromValue(new Bank("SrDell","Huelva",new BigDecimal("99999999.99"),new BankType("Banco de Inversión", "Banco que se especializa en servicios de inversión y asesoramiento financiero.", new BigDecimal("10000000.00")))))
                .exchange()
                .expectStatus()
                .isNotFound();
    }

    @Test
    void testUpdateIncreaseBankAccountBalance(){
        this.webTestClient
                .patch()
                .uri(BANKS +BANK_NAME+ACCOUNTS+NUM_ACCOUNT,"SrDell","5678-1234-7890-2345")
                .body(BodyInserters.fromValue(new BigDecimal("100.00")))
                .exchange()
                .expectStatus().isOk()
                .expectBody(BankAccount.class)
                .value(Assertions::assertNotNull)
                .value(
                        bankAccount -> {
                            assertEquals(new BigDecimal("350.50"), bankAccount.getBalance());
                        }
                );

    }
    @Test
    void testUpdateIncreaseBankAccountBalanceBankAccountNotFound(){
        this.webTestClient
                .patch()
                .uri(BANKS +BANK_NAME+ACCOUNTS+NUM_ACCOUNT,"SrDell","2343-6666-6666-6666")
                .body(BodyInserters.fromValue(new BigDecimal("200")))
                .exchange()
                .expectStatus()
                .isNotFound();
    }
}
