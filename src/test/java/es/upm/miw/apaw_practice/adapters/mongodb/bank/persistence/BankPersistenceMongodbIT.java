package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;


import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.BankSeederService;

import es.upm.miw.apaw_practice.adapters.rest.bank.dto.IncrementBalanceDto;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;

import es.upm.miw.apaw_practice.domain.models.bank.Bank;

import es.upm.miw.apaw_practice.domain.models.bank.BankAccount;
import es.upm.miw.apaw_practice.domain.models.bank.BankType;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testUpdateBankCapital(){
        Bank bank = this.bankPersistenceMongodb.readByBankName("DreamBank");
        bank.setCapital(new BigDecimal("150000000"));
        this.bankPersistenceMongodb.updateBankCapital(bank);
        Bank bankUpdated = this.bankPersistenceMongodb.readByBankName("DreamBank");
        assertEquals(new BigDecimal("150000000"), bankUpdated.getCapital());
    }

    @Test
    void testUpdateBankCapitalNotFound(){
        Bank newBank = new Bank("LuisBank","Sevilla",new BigDecimal("5000000"),new BankType("Extranjero","Banco no perteneciente al territorio nacional",new BigDecimal("1000000")));
        assertThrows(NotFoundException.class,
                () -> this.bankPersistenceMongodb.updateBankCapital(newBank));
    }

    @Test
    void testUpdateIncreaseBankAccountBalance(){
        Bank bank = this.bankPersistenceMongodb.readByBankName("DreamBank");
        IncrementBalanceDto bodyIncrement=new IncrementBalanceDto("3210-9876-5432-1098",new BigDecimal("400.00"));

        Optional<BankAccount> accountToFind = bank.getListAccounts()
                .stream()
                .filter(accountEntity -> accountEntity.getNumAccount().equals("3210-9876-5432-1098"))
                .findFirst();
        assertTrue(accountToFind.isPresent());
        assertEquals(new BigDecimal("300.00"),accountToFind.get().getBalance());

        BankAccount bankAccountUpdated=this.bankPersistenceMongodb.updateIncreaseBankAccountBalance("DreamBank",bodyIncrement);
        assertEquals(new BigDecimal("700.00"),bankAccountUpdated.getBalance());
    }

    @Test
    void testUpdateIncreaseBankAccountBalanceBankAccountNotFound(){
        Bank bank = this.bankPersistenceMongodb.readByBankName("DreamBank");
        IncrementBalanceDto bodyIncrement=new IncrementBalanceDto("9999-9211-1111-1098",new BigDecimal("777777777"));
        assertThrows(NotFoundException.class,
                () -> this.bankPersistenceMongodb.updateIncreaseBankAccountBalance(bank.getBankName(),bodyIncrement));
    }
}
