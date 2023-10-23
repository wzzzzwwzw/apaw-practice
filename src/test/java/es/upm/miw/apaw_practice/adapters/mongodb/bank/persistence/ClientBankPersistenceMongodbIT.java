package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;

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
public class ClientBankPersistenceMongodbIT {

    @Autowired
    private ClientBankPersistenceMongodb clientBankPersistenceMongodb;
    @Autowired
    private BankSeederService bankSeederService;

    @AfterEach
    void resetDataBase() {
        this.bankSeederService.deleteAll();
        this.bankSeederService.seedDatabase();
    }

    @Test
    void TestreadByDni(){
        ClientBank clientBank=this.clientBankPersistenceMongodb.readByDni("67890123H");
        assertEquals("67890123H", clientBank.getDni());
        assertEquals("Laura", clientBank.getClientName());
        assertEquals("Pérez", clientBank.getLastName());
        assertEquals(27, clientBank.getAge());
        assertEquals(1, clientBank.getListAccounts().size());
    }
    @Test
    void testDelete(){
        ClientBank clientBankBorrado=this.clientBankPersistenceMongodb.readByDni("67890123H");
        assertEquals("67890123H", clientBankBorrado.getDni());
        assertEquals("Laura", clientBankBorrado.getClientName());
        assertEquals("Pérez", clientBankBorrado.getLastName());
        assertEquals(27, clientBankBorrado.getAge());
        assertEquals(1, clientBankBorrado.getListAccounts().size());

        this.clientBankPersistenceMongodb.delete("67890123H");

        assertThrows(NotFoundException.class, () -> {
            this.clientBankPersistenceMongodb.readByDni(clientBankBorrado.getDni());
        });

    }

    @Test
    void TestNotFoundReadByDni(){
        assertThrows(NotFoundException.class, () -> {
            this.clientBankPersistenceMongodb.readByDni("67890123SSH");
        });
    }
    @Test
    void testNotFoundDelete() {
        assertThrows(NotFoundException.class, () -> {
            this.clientBankPersistenceMongodb.delete("234567wew");
        });
    }
    @Test
    void testFindTypeNamesByDni(){
        List<String>typeNames=this.clientBankPersistenceMongodb.findTypeNamesByDni("23456789D");
        assertEquals(2,typeNames.size());
        assertTrue(typeNames.contains("Banco Comercial"));
        assertTrue(typeNames.contains("Banco de Inversión"));
    }

    @Test
    void testFindTypeNamesByDniNoDuplicated(){
        List<String>typeNames=this.clientBankPersistenceMongodb.findTypeNamesByDni("87654321B");
        assertEquals(1,typeNames.size());
        assertTrue(typeNames.contains("Banco de Inversión"));
    }

    @Test
    void testFindTypeNamesByDniNotFound(){
        assertEquals(0,this.clientBankPersistenceMongodb.findTypeNamesByDni("777632P").size());
    }


}
