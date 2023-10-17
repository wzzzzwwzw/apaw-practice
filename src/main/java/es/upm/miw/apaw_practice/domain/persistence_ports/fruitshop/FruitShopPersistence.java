package es.upm.miw.apaw_practice.domain.persistence_ports.fruitshop;

import es.upm.miw.apaw_practice.domain.models.fruitShop.FruitShop;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface FruitShopPersistence {
    void delete(String name);
    FruitShop updateAddress(String name);

    Stream<FruitShop> findAddressByFruitSpecie(String specie);
}
