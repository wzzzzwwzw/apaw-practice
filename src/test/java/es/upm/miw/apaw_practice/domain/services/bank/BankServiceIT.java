package es.upm.miw.apaw_practice.domain.services.bank;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.BankSeederService;
import es.upm.miw.apaw_practice.domain.models.bank.Bank;
import es.upm.miw.apaw_practice.domain.models.bank.BankType;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class BankServiceIT {
    @Autowired
    private BankService bankService;

    @Autowired
    private BankTypeService bankTypeService;
    @Autowired
    private BankSeederService bankSeederService;

    @AfterEach
    void resetDataBase() {
        this.bankSeederService.deleteAll();
        this.bankSeederService.seedDatabase();
    }

    @Test
    void testreadByBankName(){
        Bank bank=bankService.readByBankName("Bank Pavon");
        assertEquals("Bank Pavon",bank.getBankName());
        assertEquals( new BigDecimal("12000000.00"),bank.getCapital());
        assertEquals("Barcelona",bank.getLocation());
        assertEquals(3,bank.getListAccounts().size());

    }

    @Test
    void testCreateBank(){
        BankType bankType= this.bankTypeService.read("Banco Comercial");
        Bank bank = new Bank("Sadabell","Zaragoza",new BigDecimal("999999990"),bankType );
        Bank bankCreated=this.bankService.createBank(bank);
        assertEquals("Sadabell", bankCreated.getBankName());
        assertEquals("Zaragoza", bankCreated.getLocation());
        assertEquals(new BigDecimal("999999990"), bankCreated.getCapital());
        assertEquals(0,bankCreated.getListAccounts().size());

    }

    @Test
    void testUpdateBankCapital(){
        Bank bank = this.bankService.updateBankCapital("Bank Pavon",new BigDecimal("23000000.00"));
        assertEquals("Bank Pavon", bank.getBankName());
        assertEquals(new BigDecimal("23000000.00"), bank.getCapital());
    }
}
