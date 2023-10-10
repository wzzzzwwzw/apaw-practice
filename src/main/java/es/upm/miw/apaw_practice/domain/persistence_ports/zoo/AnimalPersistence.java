package es.upm.miw.apaw_practice.domain.persistence_ports.zoo;

import es.upm.miw.apaw_practice.domain.models.zoo.Animal;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface AnimalPersistence {
    Animal readByIdentificationChip(String identificationChip);

    Animal update(Animal animal);

    Stream<Animal> readAll();
}
