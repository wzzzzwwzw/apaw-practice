package es.upm.miw.apaw_practice.domain.services.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.Dish;
import es.upm.miw.apaw_practice.domain.models.restaurant.Menu;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.DishPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.MenuPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DishService {

    private final DishPersistence dishPersistence;
    private final MenuPersistence menuPersistence;

    @Autowired
    DishService(DishPersistence dishPersistence, MenuPersistence menuPersistence) {
        this.dishPersistence = dishPersistence;
        this.menuPersistence = menuPersistence;
    }

    public Dish updatePrice(String title, BigDecimal price) {
        Dish dish = this.dishPersistence.readByTitle(title);
        dish.setPrice(price);
        return this.dishPersistence.update(dish);
    }

    public void increasePrices(Float increment) {
        this.dishPersistence.increasePrices(increment);
    }

    public BigDecimal findSumOfPriceByAvailableAndLastModification(Boolean available, LocalDateTime lastModification) {
        List<Menu> menus = this.menuPersistence.findAllMenusByLastModificationBeforeXDays(30);

        return menus.stream()
                .filter(menu -> menu.getDishes().stream()
                        .anyMatch(dish -> dish.getIngredients().stream()
                                .anyMatch(ingredient -> ingredient.isAvailable() == available)))
                .map(menu -> menu.getDishes().stream()
                        .map(Dish::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
