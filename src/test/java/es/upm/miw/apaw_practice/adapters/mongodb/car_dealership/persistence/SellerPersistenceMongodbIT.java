package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.car_dealership.Seller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class SellerPersistenceMongodbIT {

    @Autowired
    private SellerPersistenceMongodb sellerPersistence;

    @Test
    void testCreateAndRead() {
        Seller seller = new Seller("NewName", "NewSurname", 1000);
        this.sellerPersistence.create(seller);
        Optional<Seller> sellerDB = this.sellerPersistence.readAll()
                .filter(seller1 -> "NewName".equals(seller1.getName()))
                .findFirst();
        assertTrue(sellerDB.isPresent());
        assertEquals("NewName", sellerDB.get().getName());
        assertEquals("NewSurname", sellerDB.get().getSurname());
        assertEquals(1000, sellerDB.get().getSalary());
    }

}
