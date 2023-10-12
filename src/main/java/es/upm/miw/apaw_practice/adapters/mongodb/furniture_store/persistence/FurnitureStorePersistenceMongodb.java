package es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.daos.FurnitureStoreRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.furniture_store.FurnitureStore;
import es.upm.miw.apaw_practice.domain.persistence_ports.furniture_store.FurnitureStorePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("furnitureStoreRepository")
public class FurnitureStorePersistenceMongodb implements FurnitureStorePersistence {

    private final FurnitureStoreRepository furnitureStoreRepository;

    @Autowired
    public FurnitureStorePersistenceMongodb(FurnitureStoreRepository furnitureStoreRepository) {
        this.furnitureStoreRepository = furnitureStoreRepository;
    }

    public FurnitureStore readByName(String name) {
        return this.furnitureStoreRepository
                .findByName(name)
                .orElseThrow(() -> new NotFoundException("Furniture store name: " + name))
                .toFurnitureStore();
    }

}
