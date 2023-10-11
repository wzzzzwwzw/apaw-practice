package es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.persistence;


import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.daos.TransportRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.entities.TransportEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.food_delivery.Transport;
import es.upm.miw.apaw_practice.domain.persistence_ports.food_delivery.TransportPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("transportPersistence")
public class TransportPersistenceMongodb implements TransportPersistence {

    private final TransportRepository transportRepository;

    @Autowired
    public TransportPersistenceMongodb(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

    @Override
    public Transport readByCode(String code) {
        return this.transportRepository
                .findByCode(code)
                .orElseThrow(() -> new NotFoundException("Transport code:" + code))
                .toTransport();
    }

    @Override
    public Transport updateTransportAvalaible(Transport transport) {
        TransportEntity transportEntity = this.transportRepository
                .findByCode(transport.getCode())
                .orElseThrow(() -> new NotFoundException("Transport code: " + transport.getCode()));
        transportEntity.setAvalaible(transport.getAvalaible());
        return this.transportRepository.save(transportEntity).toTransport();

    }
}
