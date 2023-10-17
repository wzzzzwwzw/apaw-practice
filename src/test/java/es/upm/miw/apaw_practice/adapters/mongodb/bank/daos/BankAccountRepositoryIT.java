package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankAccountEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class BankAccountRepositoryIT {

    @Autowired
    private BankAccountRepository bankAccountRepository;
    private static final String NUMACCOUNT="1357-8642-9081-2468";

    private static final LocalDate EXPIRATION= LocalDate.of(2024, 11, 9);


    private static final Integer CVV = 135;

    private static final BigDecimal BALANCE= new BigDecimal("875.25");

    @Test
    void testCreateAndRead() {
        assertTrue(this.bankAccountRepository.findAll().stream()
                .anyMatch(bankAccount->
                        bankAccount.getNumAccount().equals("7890-2345-6789-1234") &&
                                bankAccount.getCvv().equals(789) &&
                                bankAccount.getExpiration().equals(LocalDate.of(2026, 3, 12))
                                && bankAccount.getBalance().equals(new BigDecimal("6000.50"))
                ));
    }

    @Test
    void findByNumAccount(){
        assertTrue(this.bankAccountRepository.findByNumAccount(NUMACCOUNT).isPresent());
        BankAccountEntity bankAccount= this.bankAccountRepository.findByNumAccount(NUMACCOUNT).get();
        assertEquals(CVV,bankAccount.getCvv());
        assertEquals(BALANCE,bankAccount.getBalance());
        assertEquals(EXPIRATION,bankAccount.getExpiration());
    }




}
