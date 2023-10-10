package es.upm.miw.apaw_practice.domain.persistence_ports.food_delivery;

import es.upm.miw.apaw_practice.domain.models.food_delivery.Transport;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportPersistence {

    Transport readByCode(String code);

    Transport updateTransportAvalaible(Transport transport);
}
