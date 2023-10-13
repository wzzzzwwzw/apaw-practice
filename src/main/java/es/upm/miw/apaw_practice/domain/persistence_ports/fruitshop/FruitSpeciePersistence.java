package es.upm.miw.apaw_practice.domain.persistence_ports.fruitshop;

import es.upm.miw.apaw_practice.domain.models.fruitShop.FruitSpecie;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitSpeciePersistence {
    boolean existSpecie(String specie);
    FruitSpecie create(FruitSpecie fruitSpecie);

}
