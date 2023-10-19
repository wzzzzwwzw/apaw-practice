package es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.FurnitureStoreSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.furniture_store.Furniture;
import es.upm.miw.apaw_practice.domain.models.furniture_store.FurnitureStore;
import es.upm.miw.apaw_practice.domain.models.furniture_store.Material;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class FurnitureStorePersistenceMongodbIT {

    @Autowired
    private FurnitureStorePersistenceMongodb furnitureStorePersistenceMongodb;

    @Autowired
    private FurnitureStoreSeederService furnitureStoreSeederService;

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

    @Test
    void testUpdate() {
        FurnitureStore furnitureStore = this.furnitureStorePersistenceMongodb.readByName("ikia");
        assertNotNull(furnitureStore);

        Material material = new Material("aluminio", "metal", 7);
        List<Furniture> furnitureList = List.of(new Furniture("mesa comedor 100 x 200", new BigDecimal("97.97"), List.of(material)));
        furnitureStore.setFurnitures(furnitureList);

        this.furnitureStorePersistenceMongodb.update(furnitureStore);

        FurnitureStore newFurnitureStore = this.furnitureStorePersistenceMongodb.readByName("ikia");
        assertNotNull(newFurnitureStore);
        assertEquals(1, newFurnitureStore.getFurnitures().size());
        assertEquals("mesa comedor 100 x 200", newFurnitureStore.getFurnitures().get(0).getName());
        assertEquals(new BigDecimal("97.97"), newFurnitureStore.getFurnitures().get(0).getPrice());
        assertEquals(1, newFurnitureStore.getFurnitures().get(0).getMaterials().size());
        assertEquals("aluminio", newFurnitureStore.getFurnitures().get(0).getMaterials().get(0).getName());
        furnitureStoreSeederService.deleteAll();
        furnitureStoreSeederService.seedDatabase();
    }

    @Test
    void testUpdateNotFound() {
        FurnitureStore furnitureStore = this.furnitureStorePersistenceMongodb.readByName("ikia");
        assertNotNull(furnitureStore);

        Material material = new Material("abeto", "madera", 7);
        List<Furniture> furnitureList = List.of(new Furniture("mesa comedor 100 x 200", new BigDecimal("97.97"), List.of(material)));
        furnitureStore.setFurnitures(furnitureList);

        assertThrows(NotFoundException.class, () -> this.furnitureStorePersistenceMongodb.update(furnitureStore));

    }

    @Test
    void testFindFurnitureStoreNameByManagerPromotionCandidate() {
        Stream<Furniture> furnitureStream = this.furnitureStorePersistenceMongodb.findFurnitureStoreNameByManagerPromotionCandidate(true);
        assertNotNull(furnitureStream);
        assertEquals(3, furnitureStream.count());
    }

}
