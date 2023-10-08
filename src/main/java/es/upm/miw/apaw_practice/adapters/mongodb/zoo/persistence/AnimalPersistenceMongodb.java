package es.upm.miw.apaw_practice.adapters.mongodb.zoo.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.shop.daos.ArticleRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.daos.ShoppingCartRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.entities.ArticleItemEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.entities.ShoppingCartEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.daos.AnimalRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.entities.AnimalEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.zoo.Animal;
import es.upm.miw.apaw_practice.domain.persistence_ports.zoo.AnimalPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.stream.Collectors;

@Repository("animalPersistence")
public class AnimalPersistenceMongodb implements AnimalPersistence {

    private final AnimalRepository animalRepository;



    @Autowired
    public AnimalPersistenceMongodb(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
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

        animalEntity.setAge(animal.getAge());
        return this.animalRepository.save(animalEntity).toAnimal();
    }
}
