package es.upm.miw.apaw_practice.adapters.mongodb.zoo.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.zoo.Animal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class AnimalRepositoryIT {
    @Autowired
    private AnimalRepository animalRepository;


    @Test
    void testReadByIdentificationChip() {
        Animal animal = this.animalRepository.findByIdentificationChip("001DOG").get().toAnimal();
        assertNotNull(animal);
        assertEquals("001DOG", animal.getIdentificationChip());
        assertEquals("KIRA", animal.getName());
        assertEquals(2, animal.getAge());
        assertEquals("familiaris", animal.getTaxonomicSpecie().getSpeciesName());
    }


}
