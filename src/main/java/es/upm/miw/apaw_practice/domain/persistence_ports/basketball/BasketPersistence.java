package es.upm.miw.apaw_practice.domain.persistence_ports.basketball;
import es.upm.miw.apaw_practice.domain.models.basketball.Basket;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketPersistence {
    Basket update(Basket basket);

    Basket read(String id);

    List<Basket> findAll();
}
