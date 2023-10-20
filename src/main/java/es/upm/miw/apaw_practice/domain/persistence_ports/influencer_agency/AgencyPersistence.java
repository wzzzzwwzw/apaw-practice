package es.upm.miw.apaw_practice.domain.persistence_ports.influencer_agency;

import org.springframework.stereotype.Repository;


@Repository
public interface AgencyPersistence {
    void deleteAgenciesStartingWith(String prefix);
}
