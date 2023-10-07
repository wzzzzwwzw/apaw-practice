package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.CategoryRestaurantRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.DishRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.IngredientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.CategoryRestaurantEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.DishEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.IngredientEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.entities.ArticleItemEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.entities.ShoppingCartEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.restaurant.Dish;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.DishPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public Dish update(Dish dish) {
        DishEntity dishEntity = this.dishRepository
                .findByTitle(dish.getTitle())
                .orElseThrow(() -> new NotFoundException("Dish title:" + dish.getTitle()));
        List<IngredientEntity> ingredients = dish.getIngredients().stream()
                .map(ingredient -> new IngredientEntity(
                        this.ingredientRepository
                                .findByName(ingredient.getName())
                                .orElseThrow(() -> new NotFoundException("Ingredient name: "
                                        + ingredient.getName()))
                                .getName(),
                        ingredient.isSpicy(),
                        ingredient.isAvailable())
                ).toList();
        CategoryRestaurantEntity categoryRestaurant = this.categoryRestaurantRepository.
                findByTag(dish.getCategory().getTag())
                .orElseThrow(() -> new NotFoundException("CategoryRestaurant tag:" + dish.getCategory().getTag()));
        dishEntity.setIngredients(ingredients);
        dishEntity.setCategory(categoryRestaurant);
        return this.dishRepository.save(dishEntity).toDish();
    }

}
