package es.upm.miw.apaw_practice.domain.models.restaurant;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DishIT {

    @Test
    void testDishBuilder() {
        Dish dish = new Dish.Builder()
                .title("Plato_prueba")
                .price(new BigDecimal("1"))
                .category(new CategoryRestaurant("Postre", "Amarillo"))
                .ingredients(List.of(new Ingredient("Platano", false, true)))
                .build();
        assertNotNull(dish);
        assertEquals("Plato_prueba", dish.getTitle());
        assertEquals(BigDecimal.ONE, dish.getPrice());
        assertEquals("Postre", dish.getCategory().getTag());
        assertEquals("Platano", dish.getIngredients().get(0).getName());
    }
}
