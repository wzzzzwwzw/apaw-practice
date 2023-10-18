package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;


import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.BankSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;

import es.upm.miw.apaw_practice.domain.models.bank.Bank;

import es.upm.miw.apaw_practice.domain.models.bank.BankType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
public class BankPersistenceMongodbIT {

    @Autowired
    private BankTypePersistenceMongodb bankTypePersistenceMongodb;
    @Autowired
    private BankPersistenceMongodb bankPersistenceMongodb;
    @Autowired
    private BankSeederService bankSeederService;


    @AfterEach
    void resetDataBase() {
        this.bankSeederService.deleteAll();
        this.bankSeederService.seedDatabase();
    }


    @Test
    void testReadByBankName() {
        Bank bank = this.bankPersistenceMongodb.readByBankName("SrDell");
        assertEquals("SrDell", bank.getBankName());
        assertEquals("Madrid", bank.getLocation());
        assertEquals(new BigDecimal("90000000.00"), bank.getCapital());
        assertEquals(7, bank.getListAccounts().size());

    }

    @Test
    void TestNotFoundReadBankName(){
        assertThrows(NotFoundException.class, () -> {
            this.bankPersistenceMongodb.readByBankName("ACB");
        });
    }

    @Test
    void testCreateBank() {
        BankType bankType= this.bankTypePersistenceMongodb.readByTypeName("Banco Comercial");
        Bank bank = new Bank("Sadabell","Zaragoza",new BigDecimal("999999990"),bankType );
        Bank bankCreated=this.bankPersistenceMongodb.createBank(bank);
        assertEquals("Sadabell", bankCreated.getBankName());
        assertEquals("Zaragoza", bankCreated.getLocation());
        assertEquals(new BigDecimal("999999990"), bankCreated.getCapital());
        assertEquals(0,bankCreated.getListAccounts().size());

    }
}
