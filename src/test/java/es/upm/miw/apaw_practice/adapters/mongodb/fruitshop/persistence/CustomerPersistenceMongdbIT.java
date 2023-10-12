package es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
public class CustomerPersistenceMongdbIT {
    @Autowired
    private CustomerPersistenceMongdb customerPersistenceMongdb;

    @Test
    void testReadNotFound(){
        assertThrows(NotFoundException.class,() ->this.customerPersistenceMongdb.findByIdCustomer(8990));
    }
    @Test
    void testReadFound(){
        assertNotNull(this.customerPersistenceMongdb.findByIdCustomer(1));
    }
}
