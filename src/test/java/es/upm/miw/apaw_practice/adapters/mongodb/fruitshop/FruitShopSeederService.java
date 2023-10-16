package es.upm.miw.apaw_practice.adapters.mongodb.fruitshop;

import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.daos.*;
import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities.CustomerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities.FruitEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities.FruitShopEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities.FruitSpecieEntity;
import es.upm.miw.apaw_practice.domain.models.fruitShop.Customer;
import es.upm.miw.apaw_practice.domain.models.fruitShop.FruitSpecie;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;


@Service
public class FruitShopSeederService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FruitRepository fruitRepository;

    @Autowired
    private FruitShopRepository fruitShopRepository;

    @Autowired
    private FruitSpecieRepository fruitspecieRepository;

    public void seedDatabase(){
        LogManager.getLogger(this.getClass()).warn("------- Fruit Shop Initial Load -----------");
        FruitSpecieEntity[] fruitSpecies = {
                new FruitSpecieEntity(new FruitSpecie("Tropical","Spring",8)),
                new FruitSpecieEntity(new FruitSpecie("Drupes","Summer",10)),
                new FruitSpecieEntity(new FruitSpecie("Normal","Autumn",15)),
                new FruitSpecieEntity(new FruitSpecie("Citrus","Winter",5)),

        };
        this.fruitspecieRepository.saveAll(Arrays.asList(fruitSpecies));

        CustomerEntity[] customers = {
                new CustomerEntity(new Customer(1,"688-576-678","ada2@gmail.com")),
                new CustomerEntity(new Customer(2,"678-236-900","4577eric@gmail.com")),
                new CustomerEntity(new Customer(3,"6898-545-000","ylss@gmail.com")),
                new CustomerEntity(new Customer(4,"634-556-112","wop@gmail.com")),

        };
        this.customerRepository.saveAll(Arrays.asList(customers));

        FruitEntity[] fruits = {
                new FruitEntity("Mango", new BigDecimal("7.5"), true, LocalDate.of(2023,1,18), fruitSpecies[0], Arrays.asList(customers[0])),
                new FruitEntity("Peach", new BigDecimal("13"), false, LocalDate.of(2023,3,8), fruitSpecies[1], Arrays.asList(customers[1],customers[2])),
                new FruitEntity("Apple", new BigDecimal("6.6"), false, LocalDate.of(2023,4,9), fruitSpecies[2], Arrays.asList(customers[2],customers[3])),
                new FruitEntity("Orange", new BigDecimal("4"), false, LocalDate.of(2023,10,27), fruitSpecies[3], Arrays.asList(customers[0],customers[1],customers[3])),

        };
        this.fruitRepository.saveAll(Arrays.asList(fruits));


        FruitShopEntity[] fruitShops = {
                new FruitShopEntity("Frutas Frescas", "Madrid", Arrays.asList(fruits[0],fruits[1])),
                new FruitShopEntity("Fruit Haven", "Barcelona", Arrays.asList(fruits[0])),
                new FruitShopEntity("Fruitful Delights", "Malaga", Arrays.asList(fruits[0],fruits[1],fruits[2],fruits[3])),
                new FruitShopEntity("Fruit Test", "Barcelona", Arrays.asList(fruits[0])),

        };
       this.fruitShopRepository.saveAll(Arrays.asList(fruitShops));

    }

    public void deleteAll() {
        this.fruitRepository.deleteAll();
        this.fruitShopRepository.deleteAll();
        this.fruitspecieRepository.deleteAll();
        this.customerRepository.deleteAll();
    }

}

