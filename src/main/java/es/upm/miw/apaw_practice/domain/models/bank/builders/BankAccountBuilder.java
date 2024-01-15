package es.upm.miw.apaw_practice.domain.models.bank.builders;

import es.upm.miw.apaw_practice.domain.models.bank.BankAccount;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface BankAccountBuilder {

    interface NumAccount{
        Expiration numAccount(String numAccount);
    }

    interface Expiration{
        Cvv expiration(LocalDate expiration);
    }

    interface Cvv{
        Balance cvv(Integer cvv);
    }

    interface Balance{
        Build balance(BigDecimal balance);
    }

    interface Build {
        BankAccount build();
    }
}
