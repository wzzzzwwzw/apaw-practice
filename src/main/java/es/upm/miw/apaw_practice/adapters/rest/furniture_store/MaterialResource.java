package es.upm.miw.apaw_practice.adapters.rest.furniture_store;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.furniture_store.Material;
import es.upm.miw.apaw_practice.domain.services.furniture_store.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
        String promotionCandidateString = new LexicalAnalyzer().extractWithAssure(q, "promotion-candidate");
        Boolean promotionCandidate = null;

        if (Objects.equals(promotionCandidateString, "true") || Objects.equals(promotionCandidateString, "false")) {
            promotionCandidate = Boolean.valueOf(promotionCandidateString);
        }
        return this.materialService.findUniqueMaterialTypeByManagerPromotionCandidate(promotionCandidate);
    }


}
