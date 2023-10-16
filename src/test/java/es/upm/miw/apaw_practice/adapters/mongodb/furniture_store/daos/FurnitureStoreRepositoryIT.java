package es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.entities.FurnitureStoreEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class FurnitureStoreRepositoryIT {

    @Autowired
    private FurnitureStoreRepository furnitureStoreRepository;

    @Test
    void testFindByName() {
        assertTrue(this.furnitureStoreRepository.findByName("ikia").isPresent());
        FurnitureStoreEntity furnitureStoreEntity = this.furnitureStoreRepository.findByName("ikia").get();
        assertEquals("456745674567", furnitureStoreEntity.getManagerEntity().getAffiliationNumber());
        assertEquals(LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.of(9, 0)), furnitureStoreEntity.getOpeningTime());
        assertEquals(LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.of(20, 30)), furnitureStoreEntity.getCloseTime());

        assertTrue(furnitureStoreEntity.getFurnitureEntities().stream()
                .anyMatch(furniture ->
                        furniture.getPrice().equals(new BigDecimal("150")) &&
                                furniture.getName().equals("mesa extensible") &&
                                furniture.getMaterialEntities().stream()
                                        .anyMatch(materials ->
                                                materials.getName().equals("roble") &&
                                                        materials.getType().equals("madera") &&
                                                        materials.getDurability() == 8
                                        )
                )
        );

    }

}
