package es.upm.miw.apaw_practice.adapters.mongodb.zoo.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.zoo.Animal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class AnimalPersistenceMongodbIT {
    @Autowired
    private AnimalPersistenceMongodb animalPersistence;

    @Test
    void testReadByIdentificationChip() {
        Animal animal = this.animalPersistence.readByIdentificationChip("005WOLF");
        assertEquals("005WOLF", animal.getIdentificationChip());
        assertEquals("GOSH", animal.getName());
        assertEquals(8, animal.getAge());
        assertEquals("lupus", animal.getTaxonomicSpecie().getSpeciesName());
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
