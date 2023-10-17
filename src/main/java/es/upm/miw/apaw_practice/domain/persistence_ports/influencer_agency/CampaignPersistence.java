package es.upm.miw.apaw_practice.domain.persistence_ports.influencer_agency;

import es.upm.miw.apaw_practice.domain.models.influencer_agency.Campaign;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignPersistence {
    Campaign create(Campaign campaign);
}