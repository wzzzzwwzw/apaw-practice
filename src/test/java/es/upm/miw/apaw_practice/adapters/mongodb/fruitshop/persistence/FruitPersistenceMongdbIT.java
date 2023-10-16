package es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.daos.FruitRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities.FruitEntity;
import es.upm.miw.apaw_practice.domain.models.fruitShop.Fruit;
import es.upm.miw.apaw_practice.domain.persistence_ports.fruitshop.FruitPersistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class FruitPersistenceMongdbIT {
    @Autowired
    private FruitRepository fruitRepository;

    @Autowired
    private FruitPersistence fruitPersistence;

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


    @Test
    void testUpdate(){
        Fruit fruit = this.fruitPersistence.readByType("Mango");
        fruit.setUnitPrice(new BigDecimal("8.8"));
        fruit.setStockTime(LocalDate.of(2022, 9,10));

        Fruit fruitChange = fruitPersistence.update(fruit);
        assertEquals("Mango", fruitChange.getType());
        assertEquals(LocalDate.of(2022,9,10), fruitChange.getStockTime());
        assertEquals(new BigDecimal("8.8"), fruitChange.getUnitPrice());
        assertEquals(true, fruitChange.isTropical());
        assertEquals("Tropical", fruitChange.getFruitSpecie().getSpecie());
        assertEquals(1, fruit.getCustomers().size());

    }



}


