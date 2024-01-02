package es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.entities.CampaignEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CampaignRepository extends MongoRepository<CampaignEntity, String> {
    Optional<CampaignEntity> findByDescription(String campaignDescription);

}
