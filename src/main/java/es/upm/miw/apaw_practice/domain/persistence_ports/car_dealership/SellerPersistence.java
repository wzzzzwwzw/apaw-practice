package es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership;

import es.upm.miw.apaw_practice.domain.models.car_dealership.Seller;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerPersistence {
    Seller create (Seller seller);
}
