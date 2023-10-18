package es.upm.miw.apaw_practice.domain.models.fruitShop.builders;

import es.upm.miw.apaw_practice.domain.models.fruitShop.FruitSpecie;

public interface FruitSpecieBuilders {
    interface Specie {
        Optionals specie(String specie);
    }

    interface Optionals {
        Optionals season(String season);
        Optionals size(Integer size);
        FruitSpecie build();
    }

}
