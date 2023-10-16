package es.upm.miw.apaw_practice.domain.services.influencer_agency;

import es.upm.miw.apaw_practice.domain.models.influencer_agency.Campaign;
import es.upm.miw.apaw_practice.domain.persistence_ports.influencer_agency.BrandPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class BrandService {
    private final BrandPersistence brandPersistence;

    @Autowired
    public BrandService(BrandPersistence brandPersistence) {
        this.brandPersistence = brandPersistence;
    }


    public Stream<Campaign> getCampaignsByBrand(String trademark) {
        return this.brandPersistence.getCampaignsByBrand(trademark);
    }
}
