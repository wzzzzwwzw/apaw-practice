package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.ClientBankEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@TestConfig
public class ClientBankRepositoryIT {

    @Autowired
    private ClientBankRepository clientBankRepository;
    private static final String DNI="12345678A";

    private static final String NAME="Juan";

    private static final String LASTNAME="Pérez";

    private static final Integer AGE=30;


    @Test
    void testCreateAndRead() {
        assertTrue(this.clientBankRepository.findAll().stream()
                .anyMatch(clientBank ->
                        clientBank.getDni().equals("34567890E") &&
                        clientBank.getClientName().equals("Luis") &&
                                clientBank.getAge().equals(29) &&
                                clientBank.getLastName().equals("Hernández")
                        && clientBank.getListAccountsEntities().size()==2
                ));
    }
    @Test
    void testfindByDniofClientBank(){
        assertTrue(this.clientBankRepository.findByDni(DNI).isPresent());
        ClientBankEntity clientbank = this.clientBankRepository.findByDni(DNI).get();
        assertEquals(NAME, clientbank.getClientName());
        assertEquals(LASTNAME, clientbank.getLastName());
        assertEquals(AGE, clientbank.getAge());
        assertEquals(2,clientbank.getListAccountsEntities().size());
        assertTrue(clientbank.getListAccountsEntities()
                .stream()
                .anyMatch( account -> account.getNumAccount().equals("1234-5678-9012-3456")
                        && account.getBalance().equals(new BigDecimal("1000.00"))
                        && account.getCvv().equals(123)
                        && account.getExpiration().equals(LocalDate.of(2025, 12, 31))

        ));
    }

}
