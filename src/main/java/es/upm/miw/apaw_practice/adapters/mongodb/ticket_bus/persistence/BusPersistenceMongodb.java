package es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.daos.BusRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities.BusEntity;
import es.upm.miw.apaw_practice.domain.models.ticket_bus.Bus;
import es.upm.miw.apaw_practice.domain.persistence_ports.ticket_bus.BusPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("busPersistence")
public class BusPersistenceMongodb implements BusPersistence {

    private final BusRepository busRepository;

    @Autowired
    public BusPersistenceMongodb(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public void create(Bus bus) {
        this.busRepository
                .save(new BusEntity(bus));
    }

    @Override
    public boolean existReferenceBus(String busReference) {
        return this.busRepository
                .findByReferenceBus(busReference)
                .isPresent();
    }

}
