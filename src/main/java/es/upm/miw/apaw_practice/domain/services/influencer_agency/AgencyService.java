package es.upm.miw.apaw_practice.domain.services.influencer_agency;

import es.upm.miw.apaw_practice.domain.persistence_ports.influencer_agency.AgencyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgencyService {

    private final AgencyPersistence agencyPersistence;

    @Autowired
    public AgencyService(AgencyPersistence agencyPersistence) {
        this.agencyPersistence = agencyPersistence;
    }

    public void deleteAgenciesStartingWith(String prefix) {
        this.agencyPersistence.deleteAgenciesStartingWith(prefix);
    }
}