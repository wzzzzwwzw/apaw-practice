package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;


import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.BankSeederService;

import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;

import es.upm.miw.apaw_practice.domain.models.bank.Bank;

import es.upm.miw.apaw_practice.domain.models.bank.BankAccount;
import es.upm.miw.apaw_practice.domain.models.bank.BankType;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class BankPersistenceMongodbIT {


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
        BankType bankType=new BankType("Banco Comercial", "Banco que ofrece una amplia gama de servicios financieros a empresas y consumidores.", new BigDecimal("19000000.00"));
        Bank bank = new Bank("Sadabell","Zaragoza",new BigDecimal("999999990"),bankType );
        Bank bankCreated=this.bankPersistenceMongodb.createBank(bank);
        assertEquals("Sadabell", bankCreated.getBankName());
        assertEquals("Zaragoza", bankCreated.getLocation());
        assertEquals(new BigDecimal("999999990"), bankCreated.getCapital());
        assertEquals(0,bankCreated.getListAccounts().size());

    }

    @Test
    void testUpdateBank(){
        Bank bank = this.bankPersistenceMongodb.readByBankName("DreamBank");
        assertEquals(new BigDecimal("6500000.00"),bank.getCapital());
        bank.setCapital(new BigDecimal("155555555"));
        bank.setBankName("BankDream");
        bank.setListAccounts(new ArrayList<>());
        Bank bankUpdated = this.bankPersistenceMongodb.updateBank("DreamBank",bank);
        assertEquals(new BigDecimal("155555555"), bankUpdated.getCapital());
        assertEquals("BankDream",bank.getBankName());
        assertEquals(0,bankUpdated.getListAccounts().size());
    }
    @Test
    void testUpdateBankNotFound(){
        Bank updatedBank = new Bank("LuisBank","Sevilla",new BigDecimal("5000000"),new BankType("Extranjero","Banco no perteneciente al territorio nacional",new BigDecimal("1000000")));
        assertThrows(NotFoundException.class,
                () -> this.bankPersistenceMongodb.updateBank("CMP",updatedBank));
    }

    @Test
    void testUpdateIncreaseBankAccountBalance(){
        Bank bank = this.bankPersistenceMongodb.readByBankName("DreamBank");

        Optional<BankAccount> accountToFind = bank.getListAccounts()
                .stream()
                .filter(accountEntity -> accountEntity.getNumAccount().equals("3210-9876-5432-1098"))
                .findFirst();
        assertTrue(accountToFind.isPresent());
        assertEquals(new BigDecimal("300.00"),accountToFind.get().getBalance());

        BankAccount bankAccountUpdated=this.bankPersistenceMongodb.updateIncreaseBankAccountBalance("DreamBank","3210-9876-5432-1098",new BigDecimal("400.00"));
        assertEquals(new BigDecimal("700.00"),bankAccountUpdated.getBalance());
    }

    @Test
    void testUpdateIncreaseBankAccountBalanceBankAccountNotFound(){
        Bank bank = this.bankPersistenceMongodb.readByBankName("DreamBank");
        assertThrows(NotFoundException.class,
                () -> this.bankPersistenceMongodb.updateIncreaseBankAccountBalance(bank.getBankName(),"3210-3000-0020-0000",new BigDecimal("777777777")));
    }
}
