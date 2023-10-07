package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.CategoryRestaurantRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.DishRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.IngredientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.DishEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.restaurant.Dish;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.DishPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("dishPersistence")
public class DishPersistenceMongodb implements DishPersistence {

    private final DishRepository dishRepository;
    private final IngredientRepository ingredientRepository;
    private final CategoryRestaurantRepository categoryRestaurantRepository;

    @Autowired
    public DishPersistenceMongodb(DishRepository dishRepository, IngredientRepository ingredientRepository,
                                  CategoryRestaurantRepository categoryRestaurantRepository) {
        this.dishRepository = dishRepository;
        this.ingredientRepository = ingredientRepository;
        this.categoryRestaurantRepository = categoryRestaurantRepository;
    }

    @Override
    public Stream<Dish> readAll() {
        return this.dishRepository.findAll().stream()
                .map(DishEntity::toDish);
    }

    @Override
    public Dish update(Dish dish) {
        DishEntity dishEntity = this.dishRepository
                .findByTitle(dish.getTitle())
                .orElseThrow(() -> new NotFoundException("Dish title:" + dish.getTitle()));
        dishEntity.setPrice(dish.getPrice());
        return this.dishRepository.save(dishEntity).toDish();
    }

    @Override
    public Dish readByTitle(String title) {
        return this.dishRepository
                .findByTitle(title)
                .orElseThrow(() -> new NotFoundException("Dish title:" + title))
                .toDish();
    }

}
