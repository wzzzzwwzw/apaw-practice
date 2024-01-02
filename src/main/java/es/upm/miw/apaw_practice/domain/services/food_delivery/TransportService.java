package es.upm.miw.apaw_practice.domain.services.food_delivery;

import es.upm.miw.apaw_practice.domain.models.food_delivery.Transport;
import es.upm.miw.apaw_practice.domain.models.shop.ShoppingCart;
import es.upm.miw.apaw_practice.domain.persistence_ports.food_delivery.TransportPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class TransportService {

    private final TransportPersistence transportPersistence;

    @Autowired
    public TransportService (TransportPersistence transportPersistence){
        this.transportPersistence = transportPersistence;
    }

    public Transport updateTransportAvalaible(String code, Boolean avalaible){
        Transport transport = this.transportPersistence.readByCode(code);
        transport.setAvalaible(avalaible);
        return this.transportPersistence.updateTransportAvalaible(transport);
    }

    public Stream<String> findByEmailClient(String email) {
        return this.transportPersistence.findByEmailClient(email);
    }
}
