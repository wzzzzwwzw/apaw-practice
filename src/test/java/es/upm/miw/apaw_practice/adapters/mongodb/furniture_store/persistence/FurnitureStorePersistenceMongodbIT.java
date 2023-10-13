package es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.furniture_store.FurnitureStore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class FurnitureStorePersistenceMongodbIT {

    @Autowired
    private FurnitureStorePersistenceMongodb furnitureStorePersistenceMongodb;

    @Test
    void testReadByName() {
        FurnitureStore furnitureStore = this.furnitureStorePersistenceMongodb.readByName("ikia");
        assertEquals("María", furnitureStore.getManager().getName());
        assertEquals(3, furnitureStore.getFurnitures().size());
        assertEquals(9, furnitureStore.getOpeningTime().getHour());
        assertEquals(0, furnitureStore.getOpeningTime().getMinute());
        assertEquals(20, furnitureStore.getCloseTime().getHour());
        assertEquals(30, furnitureStore.getCloseTime().getMinute());
    }
}
