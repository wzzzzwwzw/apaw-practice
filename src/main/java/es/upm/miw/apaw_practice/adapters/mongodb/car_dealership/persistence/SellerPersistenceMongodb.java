package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.daos.CarRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.daos.SellerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.SellerEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.car_dealership.Seller;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership.SellerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.stream.Stream;

@Repository("sellerPersistence")
public class SellerPersistenceMongodb implements SellerPersistence {

    private final SellerRepository sellerRepository;
    private final CarRepository carRepository;

    private static final String SELLER_ID = "Seller id: ";

    @Autowired
    public SellerPersistenceMongodb(SellerRepository sellerRepository, CarRepository carRepository) {
        this.sellerRepository = sellerRepository;
        this.carRepository = carRepository;
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

    @Override
    public Stream<String> findUniqueSurnamesMore20000ByBrand(String brand) {
        return this.carRepository.findAll()
                .stream()
                .filter(carEntity -> brand.equals(carEntity.getCarModelEntity().getBrand()))
                .filter(carEntity -> carEntity.getPrice().compareTo(new BigDecimal(20000)) > 0)
                .flatMap(carEntity -> carEntity.getSellerEntities().stream())
                .map(SellerEntity::getSurname)
                .distinct();
    }
}
