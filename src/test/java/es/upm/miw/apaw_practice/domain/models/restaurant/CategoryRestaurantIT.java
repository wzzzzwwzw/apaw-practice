package es.upm.miw.apaw_practice.domain.models.restaurant;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CategoryRestaurantIT {

    @Test
    void testCategoryRestaurantBuilder() {
        LocalDateTime exampleDate = LocalDateTime.of(1, 2, 3, 4, 5);

        CategoryRestaurant category = new CategoryRestaurant.Builder()
                .tag("Categoria_prueba")
                .color("Color_prueba")
                .creationDate(exampleDate)
                .build();
        assertNotNull(category);
        assertEquals("Categoria_prueba", category.getTag());
        assertEquals("Color_prueba", category.getColor());
        assertEquals(exampleDate, category.getCreationDate());
    }
}
