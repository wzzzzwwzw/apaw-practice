package es.upm.miw.apaw_practice.adapters.mongodb.stable.persistance;

import es.upm.miw.apaw_practice.adapters.mongodb.stable.daos.HorseRepository;
import es.upm.miw.apaw_practice.domain.models.stable.Horse;
import es.upm.miw.apaw_practice.domain.persistence_ports.stable.HorsePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import es.upm.miw.apaw_practice.adapters.mongodb.stable.entities.HorseEntity;

import java.math.BigDecimal;
import java.util.stream.Stream;

@Repository("horsePersistence")
public class HorsePersistenceMongodb implements HorsePersistence {
    private final HorseRepository horseRepository;

    @Autowired
    public HorsePersistenceMongodb(HorseRepository horseRepository) {
        this.horseRepository = horseRepository;
    }

    @Override
    public Stream<Horse> findByProviderAndPriceGreaterThan(BigDecimal purchasePrice) {
        return this.horseRepository.findAll().stream()
                .filter(horse -> purchasePrice.compareTo(horse.getPurchasePrice()) < 0)
                .map(HorseEntity::toHorse);
    }
}
