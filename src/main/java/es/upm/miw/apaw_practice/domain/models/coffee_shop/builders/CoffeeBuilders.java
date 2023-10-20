package es.upm.miw.apaw_practice.domain.models.coffee_shop.builders;
import es.upm.miw.apaw_practice.domain.models.coffee_shop.Coffee;

import java.math.BigDecimal;

public interface CoffeeBuilders {
    interface CoffeeName {
        Category coffeeName(String coffee);
    }

    interface Category {
        Price category(String category);
    }

    interface Price {
        Build price(BigDecimal price);
    }

    interface Build {
        Coffee build();
    }
}
