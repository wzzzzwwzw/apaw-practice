package es.upm.miw.apaw_practice.domain.models.bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class BankAccountIT {

    @Test
    void testCreateBuilder(){
        BankAccount bankAccount=new BankAccount.Builder().numAccount("21323-3233-1234-1234").expiration(LocalDate.of(2031,3,12)).cvv(134).balance(new BigDecimal("1222000")).build();
        assertEquals("21323-3233-1234-1234",bankAccount.getNumAccount());
        assertEquals(LocalDate.of(2031,3,12),bankAccount.getExpiration());
        assertEquals(134,bankAccount.getCvv());
        assertEquals(new BigDecimal("1222000"),bankAccount.getBalance());

    }

}
