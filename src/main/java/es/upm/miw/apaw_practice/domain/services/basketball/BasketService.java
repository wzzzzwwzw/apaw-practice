package es.upm.miw.apaw_practice.domain.services.basketball;

import es.upm.miw.apaw_practice.domain.models.basketball.Basket;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.BasketPersistence;
import org.springframework.stereotype.Service;

@Service
public class BasketService {
    private final BasketPersistence basketPersistence;

    public BasketService(BasketPersistence basketPersistence) {
        this.basketPersistence = basketPersistence;
    }

    public Basket read(String id) {
        return this.basketPersistence.read(id);
    }

    public Basket updateBasket(String id, Integer value) {
        Basket basket = this.basketPersistence.read(id);
        basket.setValue(value);
        return this.basketPersistence.update(basket);
    }
}