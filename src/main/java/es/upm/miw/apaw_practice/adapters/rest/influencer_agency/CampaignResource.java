package es.upm.miw.apaw_practice.adapters.rest.influencer_agency;

import es.upm.miw.apaw_practice.domain.models.influencer_agency.Campaign;
import es.upm.miw.apaw_practice.domain.models.influencer_agency.Content;
import es.upm.miw.apaw_practice.domain.services.influencer_agency.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CampaignResource.CAMPAIGNS)
public class CampaignResource {
    public static final String CAMPAIGNS = "/influencer-agency/campaigns";
    public static final String DESCRIPTION_ID = "/{campaignDescription}";
    public static final String CONTENTS = "/contents";
    public static final String SEARCH = "/search";


    private final CampaignService campaignService;

    @Autowired
    public CampaignResource(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @PostMapping
    public Campaign create(Campaign campaign) {
        return this.campaignService.create(campaign);
    }

    @PutMapping(DESCRIPTION_ID + CONTENTS)
    public void updateContentForCampaign(@PathVariable String campaignDescription, @RequestBody Content content) {
        this.campaignService.updateContentForCampaign(campaignDescription, content);
    }

    @GetMapping(SEARCH)
    public List<String> findCreatorsByAgencyPhone(@RequestParam Integer phone) {
        return this.campaignService.findCreatorsByAgencyPhone(phone).toList();
    }
}