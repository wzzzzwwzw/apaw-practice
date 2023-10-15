package es.upm.miw.apaw_practice.domain.services.fruitshop;

import es.upm.miw.apaw_practice.domain.models.fruitShop.FruitShop;
import es.upm.miw.apaw_practice.domain.persistence_ports.fruitshop.FruitShopPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FruitShopService {
    private final FruitShopPersistence fruitShopPersistence;

    @Autowired
    public FruitShopService(FruitShopPersistence fruitShopPersistence){
        this.fruitShopPersistence = fruitShopPersistence;

    }

    public void delete(String name){
        this.fruitShopPersistence.delete(name);
    }

    public FruitShop updateAddress(String name){
        return this.fruitShopPersistence.updateAddress(name);
    }

}