package es.upm.miw.apaw_practice.domain.services.zoo;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.zoo.Animal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class AnimalServiceIT {
    @Autowired
    private AnimalService animalService;

    @Test
    void testUpdate() {
        int age = 999;
        String identificationChip = "005DOG";
        Animal animal = animalService.updateAge(identificationChip, age);
        assertNotNull(animal);
        assertEquals(identificationChip, animal.getIdentificationChip());
        assertEquals(age, animal.getAge());

        age += 1;
        Animal animalChangeAge = animalService.updateAge(identificationChip, age);
        assertNotNull(animalChangeAge);
        assertEquals(identificationChip, animalChangeAge.getIdentificationChip());
        assertEquals(age, animalChangeAge.getAge());


    }

}
