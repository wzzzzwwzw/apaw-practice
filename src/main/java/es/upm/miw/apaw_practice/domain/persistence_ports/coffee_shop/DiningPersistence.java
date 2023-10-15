package es.upm.miw.apaw_practice.domain.persistence_ports.coffee_shop;

import es.upm.miw.apaw_practice.domain.models.coffee_shop.Dining;

public interface DiningPersistence {
    boolean existDiningNumber(String dining);
    Dining create(Dining dining);
}
