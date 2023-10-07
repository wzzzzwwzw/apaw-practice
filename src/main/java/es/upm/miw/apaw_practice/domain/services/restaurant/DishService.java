package es.upm.miw.apaw_practice.domain.services.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.Dish;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.DishPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DishService {

    private final DishPersistence dishPersistence;

    @Autowired
    DishService(DishPersistence dishPersistence) {
        this.dishPersistence = dishPersistence;
    }

    public Dish updatePrice(String title, BigDecimal price) {
        return this.dishPersistence.updatePrice(title, price);
    }

}
