package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.CategoryRestaurantRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.CategoryRestaurantEntity;
import es.upm.miw.apaw_practice.domain.models.restaurant.CategoryRestaurant;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.CategoryRestaurantPersistence;
import org.springframework.stereotype.Repository;

@Repository("categoryRestaurantPersistence")
public class CategoryRestaurantPersistenceMongodb implements CategoryRestaurantPersistence {

    private final CategoryRestaurantRepository categoryRestaurantRepository;

    public CategoryRestaurantPersistenceMongodb(CategoryRestaurantRepository categoryRestaurantRepository) {
        this.categoryRestaurantRepository = categoryRestaurantRepository;
    }

    @Override
    public CategoryRestaurant create(CategoryRestaurant categoryRestaurant) {
        return this.categoryRestaurantRepository
                .save(new CategoryRestaurantEntity(categoryRestaurant.getTag(), categoryRestaurant.getColor()))
                .toCategoryRestaurant();
    }

    @Override
    public boolean existTag(String tag) {
        return this.categoryRestaurantRepository
                .findByTag(tag)
                .isPresent();
    }

}
