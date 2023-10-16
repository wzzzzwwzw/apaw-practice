package es.upm.miw.apaw_practice.domain.services.car_dealership;

import es.upm.miw.apaw_practice.domain.models.car_dealership.Seller;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership.SellerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    private final SellerPersistence sellerPersistence;

    @Autowired
    public SellerService(SellerPersistence sellerPersistence) {
        this.sellerPersistence = sellerPersistence;
    }

    public Seller create(Seller seller) {
        return this.sellerPersistence.create(seller);
    }

    public Seller updateSellerName(String id, String name) {
        Seller seller = this.sellerPersistence.readById(id);
        seller.setName(name);
        return this.sellerPersistence.updateName(seller);
    }

    public Seller updateSellerSurname(String id, String surname) {
        Seller seller = this.sellerPersistence.readById(id);
        seller.setSurname(surname);
        return this.sellerPersistence.updateSurname(seller);
    }
}
