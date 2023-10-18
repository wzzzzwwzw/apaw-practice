package es.upm.miw.apaw_practice.domain.persistence_ports.furniture_store;

import es.upm.miw.apaw_practice.domain.models.furniture_store.Furniture;
import es.upm.miw.apaw_practice.domain.models.furniture_store.FurnitureStore;

import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface FurnitureStorePersistence {

    FurnitureStore readByName(String name);
    FurnitureStore update(FurnitureStore furnitureStore);
    Stream<Furniture> findFurnitureStoreNameByManagerPromotionCandidate(Boolean promotionCandidate);

}
