package es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.daos.FruitShopRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.fruitshop.FruitShopPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("fruitShopPersistence")
public class FruitShopPersistenceMongdb implements FruitShopPersistence {
    private final FruitShopRepository fruitShopRepository;

    @Autowired
    public FruitShopPersistenceMongdb(FruitShopRepository fruitShopRepository){
        this.fruitShopRepository = fruitShopRepository;
    }

    @Override
    public void delete(String name){
        this.fruitShopRepository.deleteByName(name);
    }
}
