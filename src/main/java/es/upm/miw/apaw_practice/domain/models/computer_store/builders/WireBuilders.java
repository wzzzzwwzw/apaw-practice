package es.upm.miw.apaw_practice.domain.models.computer_store.builders;

import es.upm.miw.apaw_practice.domain.models.computer_store.Wire;

import java.math.BigDecimal;

public interface WireBuilders {
    interface Name {
        Optionals name(String name);
    }

    interface Optionals {
        Optionals length(BigDecimal length);

        Optionals jacketMaterial(String jacketMaterial);

        Wire build();
    }
}
