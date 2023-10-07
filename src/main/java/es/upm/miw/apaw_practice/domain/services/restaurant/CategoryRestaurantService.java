package es.upm.miw.apaw_practice.domain.services.restaurant;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.restaurant.CategoryRestaurant;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.CategoryRestaurantPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryRestaurantService {

    private final CategoryRestaurantPersistence categoryRestaurantPersistence;

    @Autowired
    public CategoryRestaurantService(CategoryRestaurantPersistence categoryRestaurantPersistence) {
        this.categoryRestaurantPersistence = categoryRestaurantPersistence;
    }

    public CategoryRestaurant create(CategoryRestaurant categoryRestaurant) {
        this.assertTagNotExist(categoryRestaurant.getTag());
        return this.categoryRestaurantPersistence.create(categoryRestaurant);
    }

    public void assertTagNotExist(String tag) {
        if (this.categoryRestaurantPersistence.existTag(tag)) {
            throw new ConflictException("Tag exist: " + tag);
        }
    }
}
