package es.upm.miw.apaw_practice.domain.services.furniture_store;

import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.furniture_store.Furniture;
import es.upm.miw.apaw_practice.domain.models.furniture_store.FurnitureStore;
import es.upm.miw.apaw_practice.domain.persistence_ports.furniture_store.FurnitureStorePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

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

    public FurnitureStore updateFurnitures(String name, List<Furniture> furnitureList) {
        FurnitureStore furnitureStore = this.furnitureStorePersistence.readByName(name);
        furnitureStore.setFurnitures(furnitureList);
        return this.furnitureStorePersistence.update(furnitureStore);
    }

    public BigDecimal findAverageFurniturePriceByManagerName(String name) {
        List<Furniture> furnitureList = this.furnitureStorePersistence.findFurnituresByManagerName(name);

        if (furnitureList.isEmpty()) {
            throw new NotFoundException("No furniture found with " + name + " manager name");
        }

        return furnitureList
                .stream()
                .map(Furniture::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(furnitureList.size()), RoundingMode.UNNECESSARY);
    }

}
