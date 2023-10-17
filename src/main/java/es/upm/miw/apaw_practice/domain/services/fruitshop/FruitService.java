package es.upm.miw.apaw_practice.domain.services.fruitshop;

import es.upm.miw.apaw_practice.domain.models.fruitShop.Fruit;
import es.upm.miw.apaw_practice.domain.persistence_ports.fruitshop.FruitPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FruitService {

    private final FruitPersistence fruitPersistence;

    @Autowired
    public FruitService(FruitPersistence fruitPersistence){
        this.fruitPersistence = fruitPersistence;
    }

    public Fruit updateUnitPrice(String Type, BigDecimal unitPrice){
        Fruit fruit = this.fruitPersistence.readByType(Type);
        fruit.setUnitPrice(unitPrice);
        return this.fruitPersistence.update(fruit);
    }
}
