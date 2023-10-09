package es.upm.miw.apaw_practice.domain.services.zoo;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.zoo.Animal;
import es.upm.miw.apaw_practice.domain.models.zoo.TaxonomicSpecie;
import es.upm.miw.apaw_practice.domain.persistence_ports.zoo.AnimalPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.zoo.TaxonomicSpeciePersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.zoo.VaccinePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class TaxonomicSpecieService {
    private final TaxonomicSpeciePersistence taxonomicSpeciePersistence;
    private final VaccinePersistence vaccinePersistence;
    private final AnimalPersistence animalPersistence;

    @Autowired
    public TaxonomicSpecieService(TaxonomicSpeciePersistence taxonomicSpeciePersistence, VaccinePersistence vaccinePersistence, AnimalPersistence animalPersistence) {
        this.taxonomicSpeciePersistence = taxonomicSpeciePersistence;
        this.vaccinePersistence = vaccinePersistence;
        this.animalPersistence = animalPersistence;
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

    public Stream<String> findByVaccineName(String name) {

        return this.animalPersistence.readAll()
                .filter(animal -> animal.getVaccines()
                        .stream()
                        .anyMatch(vaccine -> vaccine.getName().equals(name))
                )
                .map(Animal::getTaxonomicSpecie)
                .map(TaxonomicSpecie::getGenusName)
                .distinct();
    }

}
