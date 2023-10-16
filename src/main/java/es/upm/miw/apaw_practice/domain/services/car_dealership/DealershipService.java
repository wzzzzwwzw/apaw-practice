package es.upm.miw.apaw_practice.domain.services.car_dealership;

import es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership.DealershipPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealershipService {

    private final DealershipPersistence dealershipPersistence;

    @Autowired
    public DealershipService(DealershipPersistence dealershipPersistence) {
        this.dealershipPersistence = dealershipPersistence;
    }

    public void delete(String id) {
        this.dealershipPersistence.delete(id);
    }
}
