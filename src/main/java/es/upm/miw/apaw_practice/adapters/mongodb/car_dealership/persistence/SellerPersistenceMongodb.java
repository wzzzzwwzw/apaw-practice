package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.daos.SellerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.SellerEntity;
import es.upm.miw.apaw_practice.domain.models.car_dealership.Seller;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership.SellerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("sellerPersistence")
public class SellerPersistenceMongodb implements SellerPersistence {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerPersistenceMongodb(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public Seller create(Seller seller) {
        return this.sellerRepository
                .save(new SellerEntity(seller))
                .toSeller();
    }
}
