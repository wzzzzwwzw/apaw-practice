package es.upm.miw.apaw_practice.domain.models.fruitShop.builders;

import es.upm.miw.apaw_practice.domain.models.fruitShop.Customer;
import es.upm.miw.apaw_practice.domain.models.fruitShop.Fruit;
import es.upm.miw.apaw_practice.domain.models.fruitShop.FruitSpecie;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


public interface FruitBuilders {
    interface Type {
        Optionals type(String type);
    }

    interface Optionals {
        Optionals unitPrice(BigDecimal unitPrice);
        Optionals tropical(Boolean tropical);
        Optionals stockTime(LocalDate stockTime);
        Optionals fruitSpecie(FruitSpecie fruitSpecie);
        Optionals customers(List<Customer> customers);

        Fruit build();

    }
}
