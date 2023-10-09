package es.upm.miw.apaw_practice.adapters.mongodb.zoo.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.zoo.Animal;
import es.upm.miw.apaw_practice.domain.persistence_ports.zoo.AnimalPersistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class AnimalRepositoryIT {
    @Autowired
    private AnimalRepository animalRepository;


    @Autowired
    private AnimalPersistence animalPersistence;

    @Test
    void testReadByIdentificationChip() {
        Animal animal = this.animalPersistence.readByIdentificationChip("001DOG");
        assertEquals("001DOG", animal.getIdentificationChip());
        assertEquals("KIRA", animal.getName());
        assertEquals(2, animal.getAge());
        assertEquals("familiaris", animal.getTaxonomicSpecie().getSpeciesName());
    }

    @Test
    void testUpdate() {
        Animal animal = this.animalPersistence.readByIdentificationChip("001DOG");

        animal.setAge(3);
        animal.setName("KIRAAAA");

        Animal animalChange = animalPersistence.update(animal);
        assertEquals("001DOG", animalChange.getIdentificationChip());
        assertEquals("KIRAAAA", animalChange.getName());
        assertEquals(3, animalChange.getAge());
        assertEquals("familiaris", animalChange.getTaxonomicSpecie().getSpeciesName());
    }
}
