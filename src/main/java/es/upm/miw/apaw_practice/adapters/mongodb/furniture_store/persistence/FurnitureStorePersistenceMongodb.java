package es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.daos.FurnitureStoreRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.daos.MaterialRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.entities.FurnitureEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.entities.FurnitureStoreEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.furniture_store.FurnitureStore;
import es.upm.miw.apaw_practice.domain.persistence_ports.furniture_store.FurnitureStorePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("furnitureStorePersistence")
public class FurnitureStorePersistenceMongodb implements FurnitureStorePersistence {

    private final FurnitureStoreRepository furnitureStoreRepository;
    private final MaterialRepository materialRepository;

    @Autowired
    public FurnitureStorePersistenceMongodb(FurnitureStoreRepository furnitureStoreRepository,
                                            MaterialRepository materialRepository) {
        this.furnitureStoreRepository = furnitureStoreRepository;
        this.materialRepository = materialRepository;
    }

    @Override
    public FurnitureStore readByName(String name) {
        return this.furnitureStoreRepository
                .findByName(name)
                .orElseThrow(() -> new NotFoundException("Furniture store name: " + name))
                .toFurnitureStore();
    }

    @Override
    public FurnitureStore update(FurnitureStore furnitureStore) {
        FurnitureStoreEntity furnitureStoreEntity = this.furnitureStoreRepository
                .findByName(furnitureStore.getName())
                .orElseThrow(() -> new NotFoundException("Furniture store name:" + furnitureStore.getName()));

        List<FurnitureEntity> furnitureEntities = furnitureStore.getFurnitures().stream()
                .map(furniture -> new FurnitureEntity(
                        furniture.getName(),
                        furniture.getPrice(),
                        furniture.getMaterials().stream()
                                .map(material -> this.materialRepository
                                        .findByName(material.getName())
                                        .orElseThrow(() -> new NotFoundException("Material name: "
                                                + material.getName()))
                                ).toList()
                )).toList();

        furnitureStoreEntity.setFurnitureEntities(furnitureEntities);
        return this.furnitureStoreRepository.save(furnitureStoreEntity).toFurnitureStore();
    }

}
