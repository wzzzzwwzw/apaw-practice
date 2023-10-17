package es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.influencer_agency.daos.AgencyRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.influencer_agency.AgencyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("agencyPersistence")
public class AgencyPersistenceMongodb implements AgencyPersistence {

    private final AgencyRepository agencyRepository;

    @Autowired
    public AgencyPersistenceMongodb(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    public void deleteAgenciesStartingWith(String prefix) {
        this.agencyRepository.deleteByCompanyStartingWithIgnoreCase(prefix);
    }
}