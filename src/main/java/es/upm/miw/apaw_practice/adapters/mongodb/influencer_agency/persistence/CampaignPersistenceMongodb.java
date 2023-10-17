package es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.daos.CampaignRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.entities.CampaignEntity;
import es.upm.miw.apaw_practice.domain.models.influencer_agency.Campaign;
import es.upm.miw.apaw_practice.domain.persistence_ports.influencer_agency.CampaignPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("campaignPersistence")
public class CampaignPersistenceMongodb implements CampaignPersistence {

    private final CampaignRepository campaignRepository;

    @Autowired
    public CampaignPersistenceMongodb(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public Campaign create(Campaign campaign) {
        return this.campaignRepository
                .save(new CampaignEntity(campaign))
                .toCampaign();
    }
}
