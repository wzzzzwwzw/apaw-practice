package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.CategoryRestaurantEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class CategoryRestaurantRepositoryIT {

    @Autowired
    private CategoryRestaurantRepository categoryRestaurantRepository;
    private static final String TAG = "Salsa";
    private static final String COLOR = "Gris";

    @Test
    void testFindByTag() {
        assertTrue(categoryRestaurantRepository.findByTag(TAG).isPresent());
        CategoryRestaurantEntity category = categoryRestaurantRepository.findByTag(TAG).get();
        assertEquals(TAG, category.getTag());
        assertEquals(COLOR, category.getColor());
    }

}
