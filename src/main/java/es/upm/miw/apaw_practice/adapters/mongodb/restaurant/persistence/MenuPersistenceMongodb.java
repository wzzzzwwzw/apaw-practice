package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.MenuRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.MenuPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("menuPersistence")
public class MenuPersistenceMongodb implements MenuPersistence {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuPersistenceMongodb(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public void delete(String id) {
        this.menuRepository.deleteById(id);
    }

}
