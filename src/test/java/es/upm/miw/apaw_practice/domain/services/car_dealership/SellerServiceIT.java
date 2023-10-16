package es.upm.miw.apaw_practice.domain.services.car_dealership;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.CarDealershipSeederService;
import es.upm.miw.apaw_practice.domain.models.car_dealership.Seller;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership.SellerPersistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class SellerServiceIT {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private SellerPersistence sellerPersistence;

    @Autowired
    private CarDealershipSeederService carDealershipSeederService;

    @Test
    void testUpdateSellerName() {
        String newName = "New Name";
        Optional<Seller> seller = this.sellerPersistence.readAll()
                .filter(seller1 -> "Asier".equals(seller1.getName()))
                .findFirst();
        assertTrue(seller.isPresent());

        this.sellerService.updateSellerName(seller.get().getId(), newName);
        assertTrue(this.sellerPersistence.readAll()
                .anyMatch(seller1 -> seller.get().getId().equals(seller1.getId())
                && newName.equals(seller1.getName())));
        carDealershipSeederService.deleteAll();
        carDealershipSeederService.seedDatabase();
    }
}
