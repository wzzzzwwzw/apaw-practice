package es.upm.miw.apaw_practice.adapters.rest.furniture_store;

import es.upm.miw.apaw_practice.domain.models.furniture_store.FurnitureStore;
import es.upm.miw.apaw_practice.domain.services.furniture_store.FurnitureStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(FurnitureStoreResource.FURNITURE_STORE)
public class FurnitureStoreResource {

    static final String FURNITURE_STORE = "/furniture-store/furniture-stores";

    static final String NAME_ID = "/{name}";
    private final FurnitureStoreService furnitureStoreService;

    @Autowired
    public FurnitureStoreResource(FurnitureStoreService furnitureStoreService) {
        this.furnitureStoreService = furnitureStoreService;
    }

    @GetMapping(NAME_ID)
    public FurnitureStore read(@PathVariable String name) {
        return this.furnitureStoreService.read(name);
    }

}
