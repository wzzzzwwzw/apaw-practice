package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.CoffeeShopSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.coffee_shop.CoffeeClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@TestConfig
public class CoffeeClientPersistenceMongodbIT {

    @Autowired
    private CoffeeClientPersistenceMongodb coffeeClientPersistenceMongodb;
    @Autowired
    private CoffeeShopSeederService coffeeShopSeederService;

    @BeforeEach
    void cleanUp(){
        this.coffeeShopSeederService.deleteAll();
        this.coffeeShopSeederService.seedDatabase();
    }

    @Test
    void testUpdateAddressByName() {
        CoffeeClient coffeeClient = this.coffeeClientPersistenceMongodb.updateAddressByName("client3");
        assertNotNull(coffeeClient);
        assertEquals("new address", coffeeClient.getAddress());
    }

    @Test
    void testUpdateAddressException() {
        assertThrows(NotFoundException.class, () -> this.coffeeClientPersistenceMongodb.updateAddressByName("test"));
    }

    @Test
    void testFindComputersStreamByJacketMaterial() {
        Stream<CoffeeClient> coffeeClientStream = this.coffeeClientPersistenceMongodb.getCoffeeClientStreamByCategory("Tea");
        assertNotNull(coffeeClientStream);
        assertEquals(2, coffeeClientStream.count());
    }

    @Test
    void testNotGetCoffeeClientStreamByCategory() {
        Stream<CoffeeClient> coffeeClientStream = this.coffeeClientPersistenceMongodb.getCoffeeClientStreamByCategory("test");
        assertNotNull(coffeeClientStream);
        assertEquals(0, coffeeClientStream.count());
    }

    @Test
    void testGetUniqueLocationsByCoffee() {
        List<String> uniqueLocationByCoffee = this.coffeeClientPersistenceMongodb.getUniqueLocationsByCoffee("Expresso Frappuccino");
        assertEquals(List.of("location4"), uniqueLocationByCoffee);
    }

}
