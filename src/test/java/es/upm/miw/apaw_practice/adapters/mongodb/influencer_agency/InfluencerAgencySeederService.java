package es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency;

import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.entities.*;
import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.daos.*;
import es.upm.miw.apaw_practice.domain.models.influencer_agency.Agency;
import es.upm.miw.apaw_practice.domain.models.influencer_agency.Brand;
import es.upm.miw.apaw_practice.domain.models.influencer_agency.Campaign;
import es.upm.miw.apaw_practice.domain.models.influencer_agency.Content;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class InfluencerAgencySeederService {

    @Autowired
    private AgencyRepository agencyRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private CampaignRepository campaignRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Influencer Agency Initial Load -----------");

        AgencyEntity[] agencies = {
                new AgencyEntity(new Agency("Agency1", "Address1")),
                new AgencyEntity(new Agency("Agency2", "Address2")),
                new AgencyEntity(new Agency("Agency3", "Address3")),
                new AgencyEntity(new Agency("Agency4", "Address4"))
        };
        agencies[0].setPhone(111111111);
        agencies[1].setPhone(222);
        agencies[2].setPhone(333333333);
        agencies[3].setPhone(0);
        this.agencyRepository.saveAll(Arrays.asList(agencies));

        CampaignEntity[] campaigns = {
                new CampaignEntity(new Campaign(new Date(), new Date())),
                new CampaignEntity(new Campaign(new Date(), new Date())),
                new CampaignEntity(new Campaign(new Date(), new Date())),
                new CampaignEntity(new Campaign(new Date(), new Date()))
        };
        ContentEntity[] contents = {
                new ContentEntity(new Content("Info1", "Creator1")),
                new ContentEntity(new Content("Info2", "Creator2")),
                new ContentEntity(new Content("Info3", "Creator3")),
                new ContentEntity(new Content("Info4", "Creator4"))
        };
        campaigns[0].setContents(Arrays.asList(contents[0], contents[1]));
        campaigns[0].setDescription("Description1");
        campaigns[1].setContents(List.of(contents[2]));
        campaigns[1].setDescription("Description2");
        campaigns[2].setContents(List.of(contents[3]));
        campaigns[2].setDescription("");
        campaigns[3].setContents(new ArrayList<>());
        campaigns[3].setDescription("Description4");
        this.campaignRepository.saveAll(Arrays.asList(campaigns));

        BrandEntity[] brands = {
                new BrandEntity("Brand1", agencies[0], List.of(campaigns[0], campaigns[1])),
                new BrandEntity("Brand2", agencies[1], List.of(campaigns[1])),
                new BrandEntity("Brand3", agencies[2], List.of(campaigns[0], campaigns[2], campaigns[3])),
                new BrandEntity("Brand4", agencies[3], new ArrayList<>())
        };
        brands[0].setAdvertisingBudget(new BigDecimal("1000.00"));
        brands[0].setIndustry("Industry1");
        brands[1].setAdvertisingBudget(null);
        brands[1].setIndustry("");
        brands[2].setAdvertisingBudget(new BigDecimal("0.00"));
        brands[2].setIndustry("Industry3");
        brands[3].setAdvertisingBudget(new BigDecimal("100.00"));
        brands[3].setIndustry(null);

        this.brandRepository.saveAll(Arrays.asList(brands));
    }

    public void deleteAll() {
        this.brandRepository.deleteAll();
        this.campaignRepository.deleteAll();
        this.agencyRepository.deleteAll();
    }
}
