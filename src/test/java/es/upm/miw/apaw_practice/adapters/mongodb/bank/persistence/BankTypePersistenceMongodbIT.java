package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.BankSeederService;


import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.bank.BankType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class BankTypePersistenceMongodbIT {
    @Autowired
    private BankTypePersistenceMongodb bankTypePersistenceMongodb;
    @Autowired
    private BankSeederService bankSeederService;


    @AfterEach
    void resetDataBase() {
        this.bankSeederService.deleteAll();
        this.bankSeederService.seedDatabase();
    }

    @Test
    void testReadByTypeName() {
        BankType bankType = this.bankTypePersistenceMongodb.readByTypeName("Banco de Desarrollo");
        assertEquals("Banco de Desarrollo", bankType.getTypeName());
        assertEquals("Banco público o privado que se enfoca en financiar proyectos de desarrollo y crecimiento económico en una región o país.", bankType.getDescription());
        assertEquals(bankType.getMinimunCapital(),new BigDecimal("20000000.00"));
    }

    @Test
    void TestNotFoundReadTypeName(){
        assertThrows(NotFoundException.class, () -> {
            this.bankTypePersistenceMongodb.readByTypeName("Rural");
        });
    }
}
