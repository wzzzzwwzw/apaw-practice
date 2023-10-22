package es.upm.miw.apaw_practice.domain.services.bank;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.BankSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankTypeEntity;
import es.upm.miw.apaw_practice.adapters.rest.bank.dto.IncrementBalanceDto;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.bank.Bank;
import es.upm.miw.apaw_practice.domain.models.bank.BankType;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void testUpdateBank(){
        assertEquals(new BigDecimal("12000000.00"),this.bankService.readByBankName("Bank Pavon").getCapital());
        assertEquals("Barcelona",this.bankService.readByBankName("Bank Pavon").getLocation());
        Bank bank = this.bankService.updateBank("Bank Pavon",new Bank("Bank Pavon", "Salamanca", new BigDecimal("1111111111.00"),new BankType("Banco Comercial", "Banco que ofrece una amplia gama de servicios financieros a empresas y consumidores.", new BigDecimal("19000000.00"))));
        assertEquals("Salamanca", bank.getLocation());
        assertEquals(new BigDecimal("1111111111.00"), bank.getCapital());
    }

    @Test
    void testUpdateBankNotFound(){
        assertThrows(NotFoundException.class,
                () ->this.bankService.updateBank("SAN Fierro",new Bank("DreamBank", "Vigo", new BigDecimal("6500000.00"), new BankType("General","Banco general",new BigDecimal("2")))));
    }
    @Test
    void testUpdateIncreaseBankAccountBalance(){
        Bank bank=this.bankService.readByBankName("DreamBank");
        IncrementBalanceDto bodyIncrement=new IncrementBalanceDto("7890-2345-6789-1234",new BigDecimal("1000.00"));
        assertEquals(new BigDecimal("6000.50"),bank.getListAccounts().stream()
                .filter(accountEntity -> accountEntity.getNumAccount().equals("7890-2345-6789-1234"))
                .findFirst().get().getBalance());
        assertEquals(new BigDecimal("7000.50"),this.bankService.updateIncreaseBankAccountBalance("DreamBank",bodyIncrement).getBalance());
    }

    @Test
    void testUpdateIncreaseBankAccountBalanceNotFoundNumAccount(){
        Bank bank=this.bankService.readByBankName("DreamBank");
        IncrementBalanceDto bodyIncrement=new IncrementBalanceDto("2222-9211-1111-1098",new BigDecimal("5454545"));
        assertThrows(NotFoundException.class,
                () ->this.bankService.updateIncreaseBankAccountBalance("DreamBank",bodyIncrement));
    }
}
