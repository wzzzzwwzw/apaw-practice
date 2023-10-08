package es.upm.miw.apaw_practice.domain.persistence_ports.zoo;

import es.upm.miw.apaw_practice.domain.models.zoo.TaxonomicSpecie;

public interface TaxonomicSpeciePersistence {
    TaxonomicSpecie create(TaxonomicSpecie taxonomicSpecie);

    boolean existSpeciesName(String speciesName);
}
