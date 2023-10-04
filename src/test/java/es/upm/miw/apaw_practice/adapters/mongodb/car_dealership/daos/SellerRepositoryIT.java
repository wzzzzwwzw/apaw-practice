package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class SellerRepositoryIT {

    @Autowired
    private SellerRepository sellerRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.sellerRepository.findAll().stream()
                .anyMatch(seller ->
                        "Asier".equals(seller.getName()) &&
                        "Gonzalez".equals(seller.getSurname()) &&
                        30000 == seller.getSalary()
                ));
    }
}
