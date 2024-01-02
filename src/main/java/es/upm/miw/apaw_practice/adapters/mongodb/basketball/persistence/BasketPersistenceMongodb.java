package es.upm.miw.apaw_practice.adapters.mongodb.basketball.persistence;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos.BasketRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.BasketEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.basketball.Basket;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.BasketPersistence;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("basketPersistence")
public class BasketPersistenceMongodb implements BasketPersistence {
    private final BasketRepository basketRepository;

    public BasketPersistenceMongodb(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @Override
    public Basket update(Basket basket) {
        BasketEntity basketEntity = this.basketRepository
                .findByIdentifier(basket.getIdentifier())
                .orElseThrow(() -> new NotFoundException("Basket id:" + basket.getIdentifier()));
        basketEntity.fromBasket(basket);
        return this.basketRepository
                .save(basketEntity)
                .toBasket();
    }

    @Override
    public Basket read(String identifier) {
        return this.basketRepository.findByIdentifier(identifier)
                .orElseThrow(() -> new NotFoundException("Basket id: " + identifier))
                .toBasket();
    }

    @Override
    public List<Basket> findAll() {
        return this.basketRepository.findAll()
                .stream()
                .map(BasketEntity::toBasket)
                .toList();
    }

}