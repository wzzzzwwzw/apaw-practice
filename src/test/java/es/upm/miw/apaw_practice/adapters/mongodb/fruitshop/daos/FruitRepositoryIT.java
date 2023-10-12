package es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities.FruitEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class FruitRepositoryIT {

    @Autowired
    private FruitRepository fruitRepository;

    @Test
    void testReadByType() {
        assertTrue(this.fruitRepository.findByType("Mango").isPresent());
        FruitEntity fruit = this.fruitRepository.findByType("Mango").get();
        assertNotNull(fruit);
        assertEquals(new BigDecimal("7.5"), fruit.getUnitPrice());
        assertTrue(fruit.isTropical());
        assertEquals(LocalDate.of(2023, 1, 18), fruit.getStockTime());
        assertEquals("Tropical", fruit.getFruitSpecieEntity().getSpecie());
        assertEquals(1, fruit.getCustomerEntities().size());
        this.assertCustomer( fruit, 1);
    }
        private void assertCustomer(FruitEntity fruit, Integer idCustomer){
            assertTrue(fruit.getCustomerEntities()
                    .stream()
                    .anyMatch(customers ->
                            customers.getIdCustomer().equals(idCustomer)

                    )
            );
        }


    }



