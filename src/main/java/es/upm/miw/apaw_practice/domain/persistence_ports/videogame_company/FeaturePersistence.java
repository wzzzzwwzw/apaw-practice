package es.upm.miw.apaw_practice.domain.persistence_ports.videogame_company;

import es.upm.miw.apaw_practice.domain.models.videogame_company.Feature;
import org.springframework.stereotype.Repository;

@Repository
public interface FeaturePersistence {
    Feature updateCloudSynchronization(Feature feature);

    Feature readByGenre(String genre);

}
