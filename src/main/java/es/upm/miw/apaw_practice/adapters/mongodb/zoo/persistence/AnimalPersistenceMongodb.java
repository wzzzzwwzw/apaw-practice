package es.upm.miw.apaw_practice.adapters.mongodb.zoo.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.zoo.daos.AnimalRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.daos.TaxonomicSpecieRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.daos.VaccineRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.entities.AnimalEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.entities.TaxonomicSpecieEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.entities.VaccineEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.zoo.Animal;
import es.upm.miw.apaw_practice.domain.persistence_ports.zoo.AnimalPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("animalPersistence")
public class AnimalPersistenceMongodb implements AnimalPersistence {

    private final AnimalRepository animalRepository;
    private final VaccineRepository vaccineRepository;
    private final TaxonomicSpecieRepository taxonomicSpecieRepository;


    @Autowired
    public AnimalPersistenceMongodb(AnimalRepository animalRepository, VaccineRepository vaccineRepository, TaxonomicSpecieRepository taxonomicSpecieRepository) {
        this.animalRepository = animalRepository;
        this.vaccineRepository = vaccineRepository;
        this.taxonomicSpecieRepository = taxonomicSpecieRepository;
    }

    @Override
    public Animal readByIdentificationChip(String identificationChip) {
        return this.animalRepository
                .findByIdentificationChip(identificationChip)
                .orElseThrow(() -> new NotFoundException("Animal identificationChip:" + identificationChip))
                .toAnimal();
    }

    @Override
    public Animal update(Animal animal) {
        AnimalEntity animalEntity = this.animalRepository
                .findByIdentificationChip(animal.getIdentificationChip())
                .orElseThrow(() -> new NotFoundException("Animal identificationChip:" + animal.getIdentificationChip()));

        animalEntity.setName(animal.getName());
        animalEntity.setAge(animal.getAge());

        animalEntity.setVaccineEntities(animal.getVaccines().stream()
                .map(vaccineItem -> new VaccineEntity(
                        this.vaccineRepository
                                .findByIdentifierBatch(vaccineItem.getIdentifierBatch())
                                .orElseThrow(() -> new NotFoundException("Vacine IdentifierBatch: "
                                        + vaccineItem.getIdentifierBatch())).toVaccine())


                ).toList());


        TaxonomicSpecieEntity taxonomicSpecieEntity = taxonomicSpecieRepository.findBySpeciesName(animal.getTaxonomicSpecie().getSpeciesName()).orElseThrow(() -> new NotFoundException("Vacine IdentifierBatch: "
                + animal.getTaxonomicSpecie().getSpeciesName()));
        animalEntity.setTaxonomicSpecieEntity(taxonomicSpecieEntity);
        return this.animalRepository.save(animalEntity).toAnimal();
    }

    @Override
    public Stream<Animal> readAll() {
        return this.animalRepository.findAll().stream()
                .map(AnimalEntity::toAnimal);
    }
}
