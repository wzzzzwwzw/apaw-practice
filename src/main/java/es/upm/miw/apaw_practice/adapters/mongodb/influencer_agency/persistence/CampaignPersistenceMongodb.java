package es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.daos.AgencyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.daos.BrandRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.daos.CampaignRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.entities.AgencyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.entities.CampaignEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.influencer_agency.Campaign;
import es.upm.miw.apaw_practice.domain.models.influencer_agency.Content;
import es.upm.miw.apaw_practice.domain.persistence_ports.influencer_agency.CampaignPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("campaignPersistence")
public class CampaignPersistenceMongodb implements CampaignPersistence {

    private final CampaignRepository campaignRepository;
    private final BrandRepository brandRepository;
    private final AgencyRepository agencyRepository;

    @Autowired
    public CampaignPersistenceMongodb(CampaignRepository campaignRepository, BrandRepository brandRepository, AgencyRepository agencyRepository) {
        this.campaignRepository = campaignRepository;
        this.brandRepository = brandRepository;
        this.agencyRepository = agencyRepository;
    }

    @Override
    public Campaign create(Campaign campaign) {
        return this.campaignRepository
                .save(new CampaignEntity(campaign))
                .toCampaign();
    }

    @Override
    public Campaign findByDescription(String campaignDescription) {
        return this.campaignRepository
                .findByDescription(campaignDescription)
                .orElseThrow(() -> new NotFoundException("Campaign description not found: " + campaignDescription))
                .toCampaign();
    }

    @Override
    public void save(Campaign campaign) {
        this.campaignRepository.save(new CampaignEntity(campaign));
    }

    @Override
    public Stream<String> findCreatorsByAgencyPhone(Integer phone) {
        AgencyEntity agencyEntity = this.agencyRepository.findByPhone(phone)
                .orElseThrow(() -> new NotFoundException("Agency phone not found: " + phone));

        return this.brandRepository.findByAgencyId(agencyEntity.getId())
                .orElseThrow(() -> new NotFoundException("Brand not found for agency ID: " + agencyEntity.getId()))
                .toBrand()
                .getCampaigns()
                .stream()
                .map(Campaign::getContents)
                .flatMap(contents -> contents.stream().map(Content::getCreator).distinct());
    }
}
