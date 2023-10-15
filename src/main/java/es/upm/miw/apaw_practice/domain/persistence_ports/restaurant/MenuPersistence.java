package es.upm.miw.apaw_practice.domain.persistence_ports.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuPersistence {

    void delete(String id);

    List<Menu> findAllMenusByLastModificationThisMonth();
}
