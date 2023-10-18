package es.upm.miw.apaw_practice.domain.services.bank;

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
public class BankTypeServiceIT {
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
    void testReadService() {
        BankType bankType=this.bankTypeService.read("Banco Cooperativo");

        assertEquals("Banco Cooperativo",bankType.getTypeName());
        assertEquals("Banco que es propiedad de sus miembros y opera con principios cooperativos.",bankType.getDescription());
        assertEquals(new BigDecimal("30000000.00"),bankType.getMinimunCapital());

    }

    @Test
    void TestNotFoundRead(){
        assertThrows(NotFoundException.class, () -> {
            this.bankTypeService.read("corporative");
        });
    }
}
