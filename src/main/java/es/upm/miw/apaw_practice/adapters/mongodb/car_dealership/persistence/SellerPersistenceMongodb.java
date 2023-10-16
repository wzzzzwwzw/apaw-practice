package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.daos.SellerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.SellerEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.car_dealership.Seller;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership.SellerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("sellerPersistence")
public class SellerPersistenceMongodb implements SellerPersistence {

    private final SellerRepository sellerRepository;

    private static final String SELLER_ID = "Seller id: ";

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

    @Override
    public Stream<Seller> readAll() {
        return this.sellerRepository.findAll()
                .stream()
                .map(SellerEntity::toSeller);
    }

    @Override
    public Seller readById(String id) {
        return this.sellerRepository.
                findById(id)
                .orElseThrow(() -> new NotFoundException(SELLER_ID + id))
                .toSeller();
    }

    @Override
    public Seller updateName(Seller seller) {
        SellerEntity sellerEntity = this.sellerRepository
                .findById(seller.getId())
                .orElseThrow(() -> new NotFoundException(SELLER_ID + seller.getId()));
        sellerEntity.setName(seller.getName());
        return this.sellerRepository.save(sellerEntity).toSeller();
    }

    @Override
    public Seller updateSurname(Seller seller) {
        SellerEntity sellerEntity = this.sellerRepository
                .findById(seller.getId())
                .orElseThrow(() -> new NotFoundException(SELLER_ID + seller.getId()));
        sellerEntity.setSurname(seller.getSurname());
        return this.sellerRepository.save(sellerEntity).toSeller();
    }
}
