package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.daos.DealershipRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.DealershipEntity;
import es.upm.miw.apaw_practice.domain.models.car_dealership.Dealership;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership.DealershipPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("dealershipPersistence")
public class DealershipPersistenceMongodb implements DealershipPersistence {

    private final DealershipRepository dealershipRepository;

    @Autowired
    public DealershipPersistenceMongodb(DealershipRepository dealershipRepository) {
        this.dealershipRepository = dealershipRepository;
    }

    @Override
    public void delete(String id) {
        this.dealershipRepository.deleteById(id);
    }

    @Override
    public Stream<Dealership> readAll() {
        return this.dealershipRepository.findAll()
                .stream()
                .map(DealershipEntity::toDealership);
    }
}
