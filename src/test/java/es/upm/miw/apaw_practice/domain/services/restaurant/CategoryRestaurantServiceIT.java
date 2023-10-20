package es.upm.miw.apaw_practice.domain.services.restaurant;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.restaurant.CategoryRestaurant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class CategoryRestaurantServiceIT {

    @Autowired
    CategoryRestaurantService categoryService;

    @Test
    void testCreate() {
        CategoryRestaurant category = this.categoryService.create(new CategoryRestaurant("Tag", "Color"));
        assertEquals("Tag", category.getTag());
        assertEquals("Color", category.getColor());
    }

}
