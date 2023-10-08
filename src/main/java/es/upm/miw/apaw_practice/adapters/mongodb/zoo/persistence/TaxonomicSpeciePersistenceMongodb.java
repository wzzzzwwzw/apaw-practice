package es.upm.miw.apaw_practice.adapters.mongodb.zoo.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.zoo.daos.TaxonomicSpecieRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.entities.TaxonomicSpecieEntity;
import es.upm.miw.apaw_practice.domain.models.zoo.TaxonomicSpecie;
import es.upm.miw.apaw_practice.domain.persistence_ports.zoo.TaxonomicSpeciePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("taxonomicSpeciePersistence")
public class TaxonomicSpeciePersistenceMongodb implements TaxonomicSpeciePersistence {
    private final TaxonomicSpecieRepository taxonomicSpecieRepository;

    @Autowired
    public TaxonomicSpeciePersistenceMongodb(TaxonomicSpecieRepository taxonomicSpecieRepository) {
        this.taxonomicSpecieRepository = taxonomicSpecieRepository;
    }

    @Override
    public TaxonomicSpecie create(TaxonomicSpecie taxonomicSpecie) {
        return this.taxonomicSpecieRepository
                .save(new TaxonomicSpecieEntity(taxonomicSpecie))
                .toTaxonomicSpecie();
    }

    @Override
    public boolean existSpeciesName(String speciesName) {
        return this.taxonomicSpecieRepository
                .findBySpeciesName(speciesName)
                .isPresent();
    }
}
