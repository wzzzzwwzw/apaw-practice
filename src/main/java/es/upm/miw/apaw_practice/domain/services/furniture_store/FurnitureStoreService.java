package es.upm.miw.apaw_practice.domain.services.furniture_store;

import es.upm.miw.apaw_practice.domain.models.furniture_store.FurnitureStore;
import es.upm.miw.apaw_practice.domain.persistence_ports.furniture_store.FurnitureStorePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FurnitureStoreService {

    private final FurnitureStorePersistence furnitureStorePersistence;

    @Autowired
    public FurnitureStoreService(FurnitureStorePersistence furnitureStorePersistence) {
        this.furnitureStorePersistence = furnitureStorePersistence;
    }

    public FurnitureStore read(String name) {
        return this.furnitureStorePersistence.readByName(name);
    }
}
