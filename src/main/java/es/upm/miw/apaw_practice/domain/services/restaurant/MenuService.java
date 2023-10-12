package es.upm.miw.apaw_practice.domain.services.restaurant;

import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.MenuPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    private final MenuPersistence menuPersistence;

    @Autowired
    public MenuService(MenuPersistence menuPersistence) {
        this.menuPersistence = menuPersistence;
    }

    public void delete(String id) {
        this.menuPersistence.delete(id);
    }
}
