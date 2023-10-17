package es.upm.miw.apaw_practice.adapters.rest.influencer_agency;

import es.upm.miw.apaw_practice.domain.models.influencer_agency.Campaign;
import es.upm.miw.apaw_practice.domain.services.influencer_agency.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CampaignResource.CAMPAIGNS)
public class CampaignResource {
    public static final String CAMPAIGNS = "/influencer-agency/campaigns";


    private final CampaignService campaignService;

    @Autowired
    public CampaignResource(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @PostMapping
    public Campaign create(Campaign campaign) {
        return this.campaignService.create(campaign);
    }


}