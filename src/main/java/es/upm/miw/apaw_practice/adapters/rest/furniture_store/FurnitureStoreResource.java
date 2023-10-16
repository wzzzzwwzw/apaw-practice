package es.upm.miw.apaw_practice.adapters.rest.furniture_store;

import es.upm.miw.apaw_practice.domain.models.furniture_store.FurnitureStore;
import es.upm.miw.apaw_practice.domain.models.furniture_store.Furniture;
import es.upm.miw.apaw_practice.domain.services.furniture_store.FurnitureStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(FurnitureStoreResource.FURNITURE_STORE)
public class FurnitureStoreResource {

    static final String FURNITURE_STORE = "/furniture-store/furniture-stores";
    static final String FURNITURE = "/furnitures";
    static final String NAME_ID = "/{name}";
    private final FurnitureStoreService furnitureStoreService;

    @Autowired
    public FurnitureStoreResource(FurnitureStoreService furnitureStoreService) {
        this.furnitureStoreService = furnitureStoreService;
    }

    @PutMapping(NAME_ID + FURNITURE)
    public FurnitureStore updateFurniture(@PathVariable String name, @RequestBody List<Furniture> furnitureList) {
        return this.furnitureStoreService.updateFurnitures(name, furnitureList);
    }

    @GetMapping(NAME_ID)
    public FurnitureStore read(@PathVariable String name) {
        return this.furnitureStoreService.read(name);
    }

}
