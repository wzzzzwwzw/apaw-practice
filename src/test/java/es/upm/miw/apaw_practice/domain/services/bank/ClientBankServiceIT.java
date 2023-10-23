package es.upm.miw.apaw_practice.domain.services.bank;


import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.BankSeederService;

import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.bank.ClientBank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class ClientBankServiceIT {

    @Autowired
    private ClientBankService clientBankService;
    @Autowired
    private BankSeederService bankSeederService;

    @AfterEach
    void resetDataBase() {
        this.bankSeederService.deleteAll();
        this.bankSeederService.seedDatabase();
    }

    @Test
    void TestreadByDni(){
        ClientBank clientBank=this.clientBankService.read("87654321B");

        assertEquals("87654321B",clientBank.getDni());
        assertEquals("Ana",clientBank.getClientName());
        assertEquals("García",clientBank.getLastName());
        assertEquals(28,clientBank.getAge());
        assertEquals(2,clientBank.getListAccounts().size());

    }
    @Test
    void TestNotFoundRead(){
        assertThrows(NotFoundException.class, () -> {
            this.clientBankService.read("87654321PO");
        });
    }
    @Test
    void Testdelete(){
        assertEquals("87654321B",this.clientBankService.read("87654321B").getDni());
        this.clientBankService.delete("87654321B");
        assertThrows(NotFoundException.class, () -> {
            this.clientBankService.read("87654321B");
        });
    }

    @Test
    void TestNotFoundDelete(){
        assertThrows(NotFoundException.class, () -> {
            this.clientBankService.delete("87654321PO");
        });
    }

    @Test
    void testFindTypeNamesByDni(){
        List<String> typeNames=this.clientBankService.findTypeNamesByDni("23456789D");
        assertEquals(2,typeNames.size());
        assertTrue(typeNames.contains("Banco Comercial"));
        assertTrue(typeNames.contains("Banco de Inversión"));
    }

    @Test
    void testFindTypeNamesByDniNoDuplicated(){
        List<String>typeNames=this.clientBankService.findTypeNamesByDni("87654321B");
        assertEquals(1,typeNames.size());
        assertTrue(typeNames.contains("Banco de Inversión"));
    }

    @Test
    void testFindTypeNamesByDniNotFound(){
        assertEquals(0,this.clientBankService.findTypeNamesByDni("777632P").size());
    }
}
