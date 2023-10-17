package es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.daos.CustomerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.daos.FruitRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.daos.FruitSpecieRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities.CustomerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities.FruitEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities.FruitSpecieEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.fruitShop.Fruit;
import es.upm.miw.apaw_practice.domain.persistence_ports.fruitshop.FruitPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;


@Repository("fruitpersistence")

public class FruitPersistenceMongdb implements FruitPersistence {

    private final FruitRepository fruitRepository;
    private final FruitSpecieRepository fruitSpecieRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public FruitPersistenceMongdb(FruitRepository fruitRepository, CustomerRepository customerRepository, FruitSpecieRepository fruitSpecieRepository) {

        this.fruitRepository = fruitRepository;
        this.customerRepository = customerRepository;
        this.fruitSpecieRepository = fruitSpecieRepository;

    }

    @Override
    public Fruit readByType(String type) {
        return this.fruitRepository
                .findByType(type)
                .orElseThrow(() -> new NotFoundException("Fruit type:" + type)).
                toFruit();
    }

    @Override
    public Fruit update(Fruit fruit) {
        FruitEntity fruitEntity = this.fruitRepository
                .findByType(fruit.getType())
                .orElseThrow(() -> new NotFoundException("Fruit type:" + fruit.getType()));

        fruitEntity.setStockTime(fruit.getStockTime());
        fruitEntity.setUnitPrice(fruit.getUnitPrice());

        fruitEntity.setCustomerEntities(fruit.getCustomers().stream()
                .map(customer -> new CustomerEntity(
                        this.customerRepository
                                .findByIdCustomer(customer.getIdCustomer())
                                .orElseThrow(() -> new NotFoundException("Customer ID:" + customer.getIdCustomer())).toCustomer()
                )).toList());


        FruitSpecieEntity fruitSpecieEntity = fruitSpecieRepository.findBySpecie(fruit.getFruitSpecie().getSpecie())
                .orElseThrow(() -> new NotFoundException("Fruit Specie:" + fruit.getFruitSpecie().getSpecie()));
        fruitEntity.setFruitSpecieEntity(fruitSpecieEntity);
        return this.fruitRepository.save(fruitEntity).toFruit();
    }

    @Override
    public Stream<Fruit> readAll(){
        return this.fruitRepository.findAll().stream()
                .map(FruitEntity::toFruit);

    }

}
