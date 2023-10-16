package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.CarDealershipSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.car_dealership.Seller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class SellerPersistenceMongodbIT {

    @Autowired
    private SellerPersistenceMongodb sellerPersistence;

    @Autowired
    private CarDealershipSeederService carDealershipSeederService;

    @Test
    void testReadById() {
        Optional<Seller> seller = this.sellerPersistence.readAll()
                .filter(seller1 -> "Asier".equals(seller1.getName()))
                .findFirst();
        assertTrue(seller.isPresent());
        assertNotNull(seller.get().getId());
        assertNotNull(seller.get().getSurname());
    }

    @Test
    void testReadByIdNotFound() {
        assertThrowsExactly(NotFoundException.class, () -> this.sellerPersistence.readById(""));
    }

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

    @Test
    void testUpdate() {
        Optional<Seller> seller = this.sellerPersistence.readAll()
                .filter(seller1 -> "Gonzalez".equals(seller1.getSurname()))
                .findFirst();
        assertTrue(seller.isPresent());
        seller.get().setName("Igor");
        this.sellerPersistence.updateName(seller.get());
        Optional<Seller> newSeller = this.sellerPersistence.readAll()
                .filter(seller1 -> "Gonzalez".equals(seller1.getSurname()))
                .findFirst();
        assertTrue(newSeller.isPresent());
        assertEquals(seller.get().getSalary(), newSeller.get().getSalary());
        assertEquals("Igor", newSeller.get().getName());
        carDealershipSeederService.deleteAll();
        carDealershipSeederService.seedDatabase();
    }
}
