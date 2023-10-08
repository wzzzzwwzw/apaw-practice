package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.domain.models.museum.ArtWork;
import es.upm.miw.apaw_practice.domain.services.museum.ArtWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ArtWorkResource.ARTWORKS)
public class ArtWorkResource {
    static final String ARTWORKS = "/museum/art-works";
    static final String INVENTORY_NUMBER_ID = "/{inventoryNumber}";

    private final ArtWorkService artWorkService;

    @Autowired
    public ArtWorkResource(ArtWorkService artWorkService) {
        this.artWorkService = artWorkService;
    }

    @GetMapping(INVENTORY_NUMBER_ID)
    public ArtWork read(@PathVariable String inventoryNumber) {
        return this.artWorkService.findByInventoryNumber(inventoryNumber);
    }
}
