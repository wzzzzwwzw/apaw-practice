package es.upm.miw.apaw_practice.adapters.rest.furniture_store;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.furniture_store.Material;
import es.upm.miw.apaw_practice.domain.services.furniture_store.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(MaterialResource.MATERIALS)
public class MaterialResource {

    private final MaterialService materialService;

    static final String MATERIALS = "/furniture-store/materials";

    static final String SEARCH = "/search";

    @Autowired
    public MaterialResource(MaterialService materialService) {
        this.materialService = materialService;
    }

    @PostMapping
    public Material create(@RequestBody Material material) {
        return this.materialService.create(material);
    }

    @GetMapping(SEARCH)
    public List<String> findUniqueMaterialTypeByManagerPromotionCandidate(@RequestParam String q) {
        Boolean promotionCandidate = Boolean.valueOf(new LexicalAnalyzer().extractWithAssure(q, "promotion-candidate"));
        return this.materialService.findUniqueMaterialTypeByManagerPromotionCandidate(promotionCandidate);
    }

}
