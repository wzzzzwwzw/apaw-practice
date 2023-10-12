package es.upm.miw.apaw_practice.domain.services.zoo;

import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.zoo.Animal;
import es.upm.miw.apaw_practice.domain.persistence_ports.zoo.AnimalPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class AnimalService {

    private final AnimalPersistence animalPersistence;

    @Autowired
    public AnimalService(AnimalPersistence animalPersistence) {
        this.animalPersistence = animalPersistence;
    }


    public Animal updateAge(String identificationChip, Integer age) {
        Animal animal = this.animalPersistence.readByIdentificationChip(identificationChip);
        animal.setAge(age);
        return this.animalPersistence.update(animal);
    }

    public String findByHabitat(String habitat) {
        return this.animalPersistence.readAll()
                .filter(animal -> animal.getTaxonomicSpecie().getHabitat().equals(habitat))
                .max(Comparator.comparing(Animal::getAge))
                .orElseThrow(() -> new NotFoundException("Not found animal in : " + habitat))
                .getIdentificationChip()
                ;

    }
}
