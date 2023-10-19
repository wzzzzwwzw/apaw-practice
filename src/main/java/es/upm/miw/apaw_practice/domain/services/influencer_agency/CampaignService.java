package es.upm.miw.apaw_practice.domain.services.influencer_agency;

import es.upm.miw.apaw_practice.domain.models.influencer_agency.Campaign;
import es.upm.miw.apaw_practice.domain.models.influencer_agency.Content;
import es.upm.miw.apaw_practice.domain.persistence_ports.influencer_agency.CampaignPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class CampaignService {
    private final CampaignPersistence campaignPersistence;

    @Autowired
    public CampaignService(CampaignPersistence campaignPersistence) {
        this.campaignPersistence = campaignPersistence;
    }

    public Campaign create(Campaign campaign) {
        return this.campaignPersistence.create(campaign);
    }

    public void updateContentForCampaign(String campaignDescription, Content content) {
        Campaign campaign = campaignPersistence.findByDescription(campaignDescription);
        campaign.getContents().add(content);

        campaignPersistence.save(campaign);
    }

    public Stream<String> findCreatorsByAgencyPhone(Integer phone) {
        return this.campaignPersistence.findCreatorsByAgencyPhone(phone);
    }
}