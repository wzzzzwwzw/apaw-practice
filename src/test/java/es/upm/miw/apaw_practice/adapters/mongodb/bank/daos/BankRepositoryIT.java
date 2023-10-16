package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankTypeEntity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@TestConfig
public class BankRepositoryIT {
    @Autowired
    private BankRepository bankRepository;

    private static final String BANKNAME="DreamBank";

    private static final String LOCATION="Vigo";

    private static final BigDecimal CAPITAL=new BigDecimal("6500000.00");


    @Test
    void testCreateAndRead() {
        assertTrue(this.bankRepository.findAll().stream()
                .anyMatch(bank ->
                        bank.getBankName().equals("Bank Pavon") &&
                                bank.getCapital().equals(new BigDecimal("12000000.00")) &&
                                bank.getLocation().equals("Barcelona")&&
                                bank.getBankTypeEntity().getTypeName().equals("Banco Comercial")
                ));
    }
    @Test
    void testfindByBankName(){
        assertTrue(this.bankRepository.findByBankName(BANKNAME).isPresent());
        BankEntity bank = this.bankRepository.findByBankName(BANKNAME).get();
        assertEquals(BANKNAME, bank.getBankName());
        assertEquals(LOCATION, bank.getLocation());
        assertEquals(CAPITAL, bank.getCapital());
        assertEquals("Banco Comercial", bank.getBankTypeEntity().getTypeName());
        assertEquals(3,bank.getBankAccountEntityList().size());
        assertTrue(bank.getBankAccountEntityList()
                .stream()
                .anyMatch( account -> account.getNumAccount().equals("1357-8642-9081-2468")
                        && account.getBalance().equals(new BigDecimal("875.25"))
                        && account.getCvv().equals(135)
                        && account.getExpiration().equals(LocalDate.of(2024, 11, 9))

                ));
    }


}
