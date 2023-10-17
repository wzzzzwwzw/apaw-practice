package es.upm.miw.apaw_practice.domain.services.fruitshop;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.fruitShop.Fruit;
import es.upm.miw.apaw_practice.domain.models.fruitShop.FruitSpecie;
import es.upm.miw.apaw_practice.domain.persistence_ports.fruitshop.CustomerPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.fruitshop.FruitPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.fruitshop.FruitSpeciePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class FruitSpecieService {
    private final FruitSpeciePersistence fruitSpeciePersistence;
    private final CustomerPersistence customerPersistence;

    private final FruitPersistence fruitPersistence;

    @Autowired
    public FruitSpecieService(FruitSpeciePersistence fruitSpeciePersistence, CustomerPersistence customerPersistence, FruitPersistence fruitPersistence){
        this.fruitSpeciePersistence = fruitSpeciePersistence;
        this.customerPersistence = customerPersistence;
        this.fruitPersistence = fruitPersistence;
    }

    public FruitSpecie create(FruitSpecie fruitSpecie) {
        this.assertSpeciesNotExist(fruitSpecie.getSpecie());
        return this.fruitSpeciePersistence.create(fruitSpecie);
    }

    public void assertSpeciesNotExist(String specie){
        if (this.fruitSpeciePersistence.existSpecie(specie))
        {
            throw new ConflictException("FruitSpecie already exists:" + specie);
        }
    }

    public Stream<String> findByTropicalFruitAndByPhone(String phone){
        return this.fruitPersistence.readAll()
                .filter(Fruit::isTropical)
                .filter(fruit -> hasCustomerWithPhone(fruit, phone))
                .map(Fruit::getFruitSpecie)
                .map(FruitSpecie::getSeason)
                .distinct();
    }

    private boolean hasCustomerWithPhone(Fruit fruit, String phone) {
        return fruit.getCustomers()
                .stream()
                .anyMatch(customer -> customer.getPhone().equals(phone));
    }

}
