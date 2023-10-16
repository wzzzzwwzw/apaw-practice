package es.upm.miw.apaw_practice.domain.persistence_ports.videogame_company;

import es.upm.miw.apaw_practice.domain.models.videogame_company.VideogameCompany;
import org.springframework.stereotype.Repository;

@Repository
public interface VideogameCompanyPersistence {
    boolean existVideogameCompanyName(String name);

    VideogameCompany create(VideogameCompany videogameCompany);
}
