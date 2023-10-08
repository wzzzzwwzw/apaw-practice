package es.upm.miw.apaw_practice.domain.services.zoo;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.zoo.TaxonomicSpecie;
import es.upm.miw.apaw_practice.domain.persistence_ports.zoo.TaxonomicSpeciePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxonomicSpecieService {
    private final TaxonomicSpeciePersistence taxonomicSpeciePersistence;

    @Autowired
    public TaxonomicSpecieService(TaxonomicSpeciePersistence taxonomicSpeciePersistence) {
        this.taxonomicSpeciePersistence = taxonomicSpeciePersistence;
    }

    public TaxonomicSpecie create(TaxonomicSpecie taxonomicSpecie) {
        this.assertSpeciesNameNotExist(taxonomicSpecie.getSpeciesName());
        return this.taxonomicSpeciePersistence.create(taxonomicSpecie);
    }

    public void assertSpeciesNameNotExist(String speciesName) {
        if (this.taxonomicSpeciePersistence.existSpeciesName(speciesName)) {
            throw new ConflictException("Specie Name exist: " + speciesName);
        }
    }

}
