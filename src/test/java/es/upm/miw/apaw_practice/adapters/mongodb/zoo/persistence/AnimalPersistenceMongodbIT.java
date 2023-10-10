package es.upm.miw.apaw_practice.adapters.mongodb.zoo.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.entities.AnimalEntity;
import es.upm.miw.apaw_practice.domain.models.zoo.Animal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    void readByIdentificationChip(){
        Animal animal = this.animalPersistence.readByIdentificationChip("001CAT");

        assertNotNull(animal);
        assertEquals("001CAT",animal.getIdentificationChip());
        assertEquals("BOLA",animal.getName());
        assertEquals("catus",animal.getTaxonomicSpecie().getSpeciesName());
        assertEquals(2,animal.getVaccines().stream().count());
        assertEquals(6,animal.getAge());

    }
    @Test
    void testUpdate() {
        Animal animal = this.animalPersistence.readByIdentificationChip("001CAT");

        animal.setAge(3);
        animal.setName("BOLAAA");

        Animal animalChange = animalPersistence.update(animal);
        assertEquals("001CAT", animalChange.getIdentificationChip());
        assertEquals("BOLAAA", animalChange.getName());
        assertEquals(3, animalChange.getAge());
        assertEquals("catus", animalChange.getTaxonomicSpecie().getSpeciesName());
    }

    @Test
    void testReadAll() {
        Stream<Animal> animalStream = this.animalPersistence.readAll();
        assertNotNull(animalStream);
        assertEquals(11, animalStream.count());

    }
}
