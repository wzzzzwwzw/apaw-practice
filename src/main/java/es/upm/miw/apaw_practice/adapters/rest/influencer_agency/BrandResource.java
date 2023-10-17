package es.upm.miw.apaw_practice.adapters.rest.influencer_agency;

import es.upm.miw.apaw_practice.domain.models.influencer_agency.Campaign;
import es.upm.miw.apaw_practice.domain.services.influencer_agency.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.stream.Stream;

@RestController
@RequestMapping(BrandResource.BRANDS)
public class BrandResource {
    public static final String BRANDS = "/influencer-agency/brands";
    public static final String TRADEMARK = "/{trademark}";
    public static final String CAMPAIGNS = "/campaigns";

    private final BrandService brandService;

    @Autowired
    public BrandResource(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping(TRADEMARK + CAMPAIGNS)
    public Stream<Campaign> getCampaignsByBrand(@PathVariable String trademark) {
        return this.brandService.getCampaignsByBrand(trademark);
    }

    @PatchMapping(TRADEMARK)
    public void updateBrand(@PathVariable String trademark, @RequestBody BigDecimal newBudget) {
        this.brandService.updateBrand(trademark, newBudget);
    }
}
