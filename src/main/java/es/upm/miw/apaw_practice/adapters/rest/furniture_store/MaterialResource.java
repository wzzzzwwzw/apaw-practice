package es.upm.miw.apaw_practice.adapters.rest.furniture_store;

import es.upm.miw.apaw_practice.domain.models.furniture_store.Material;
import es.upm.miw.apaw_practice.domain.services.furniture_store.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(MaterialResource.MATERIAL)
public class MaterialResource {

    static final String MATERIAL = "/furniture-store/materials";

    private final MaterialService materialService;

    @Autowired
    public MaterialResource(MaterialService materialService) {
        this.materialService = materialService;
    }

    @PostMapping
    public Material create(@RequestBody Material material) {
        return this.materialService.create(material);
    }
}
