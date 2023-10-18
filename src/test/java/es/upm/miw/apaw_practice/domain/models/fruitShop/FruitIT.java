package es.upm.miw.apaw_practice.domain.models.fruitShop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FruitIT {

    @Test
    void testFruitBuilder(){
        LocalDate exampleDate = LocalDate.of(2023, 10,31);
        Fruit fruit = new Fruit.Builder()
                .type("type_example")
                .unitPrice(new BigDecimal("1"))
                .tropical(true)
                .stockTime(exampleDate)
                .customers(List.of(new Customer(6,"678_890_000","132@gamil.com")))
                .fruitSpecie(new FruitSpecie("Normal","Spring",10))
                .build();
        assertNotNull(fruit);
        assertEquals("type_example", fruit.getType());
        assertEquals(BigDecimal.ONE, fruit.getUnitPrice());
        assertTrue(fruit.isTropical());
        assertEquals(exampleDate, fruit.getStockTime());
        assertEquals(6, fruit.getCustomers().get(0).getIdCustomer());
        assertEquals("Normal", fruit.getFruitSpecie().getSpecie());

    }
}
