package es.upm.miw.apaw_practice.domain.models.fruitShop.builders;

import es.upm.miw.apaw_practice.domain.models.fruitShop.Customer;

public interface CustomerBuilders {
    interface  IdCustomer {
        Optionals idCustomer(Integer idCustomer);
    }

    interface Optionals {
        Optionals phone(String phone);
        Optionals email(String email);
        Customer build();
    }
}
