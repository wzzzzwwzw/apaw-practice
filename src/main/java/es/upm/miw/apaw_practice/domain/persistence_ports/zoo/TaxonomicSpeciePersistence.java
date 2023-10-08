package es.upm.miw.apaw_practice.domain.persistence_ports.zoo;

import es.upm.miw.apaw_practice.domain.models.zoo.TaxonomicSpecie;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxonomicSpeciePersistence {
    TaxonomicSpecie create(TaxonomicSpecie taxonomicSpecie);

    boolean existSpeciesName(String speciesName);
}
