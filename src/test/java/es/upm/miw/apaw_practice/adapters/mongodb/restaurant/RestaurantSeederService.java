package es.upm.miw.apaw_practice.adapters.mongodb.restaurant;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.CategoryRestaurantRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.DishRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.IngredientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.MenuRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.CategoryRestaurantEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.DishEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.IngredientEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.MenuEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class RestaurantSeederService {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private CategoryRestaurantRepository categoryRestaurantRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Restaurant Initial Load -----------");

        IngredientEntity[] ingredients = {
                new IngredientEntity("Pollo", false, true),
                new IngredientEntity("Arroz", false, false),
                new IngredientEntity("Patatas", false, true),
                new IngredientEntity("Wasabi", true, false),
                new IngredientEntity("Lubina", false, true),
                new IngredientEntity("Ternera", false, false),
                new IngredientEntity("Salsa_de_setas", false, true),
        };
        ingredientRepository.saveAll(Arrays.asList(ingredients));

        CategoryRestaurantEntity[] categories = {
                new CategoryRestaurantEntity("Carne", "Rojo"),
                new CategoryRestaurantEntity("Pescado", "Azul"),
                new CategoryRestaurantEntity("Cereal", "Marron"),
                new CategoryRestaurantEntity("Tuberculo", "Verde_claro"),
                new CategoryRestaurantEntity("Salsa", "Gris"),
        };
        categoryRestaurantRepository.saveAll(Arrays.asList(categories));

        DishEntity[] dishes = {
                new DishEntity("Pollo_con_patatas", new BigDecimal("13.5"), categories[0], Arrays.asList(ingredients[0], ingredients[2])),
                new DishEntity("Lubina_con_arroz", new BigDecimal("18"), categories[1], Arrays.asList(ingredients[1], ingredients[4])),
                new DishEntity("Ternera_banhada_en_setas", new BigDecimal("23"), categories[4], Arrays.asList(ingredients[5], ingredients[6])),
        };
        dishRepository.saveAll(Arrays.asList(dishes));

        MenuEntity menu = new MenuEntity(Arrays.asList(dishes), LocalDateTime.now().minusDays(20));
        menuRepository.save(menu);
        MenuEntity oldMenu = new MenuEntity(Arrays.asList(dishes), LocalDateTime.now().minusDays(80));
        menuRepository.save(oldMenu);
    }

    public void deleteAll() {
        this.menuRepository.deleteAll();
        this.dishRepository.deleteAll();
        this.categoryRestaurantRepository.deleteAll();
        this.ingredientRepository.deleteAll();
    }

}
