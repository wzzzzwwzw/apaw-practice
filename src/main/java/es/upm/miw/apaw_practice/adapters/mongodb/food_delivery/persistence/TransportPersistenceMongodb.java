package es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.persistence;


import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.daos.ClientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.daos.TransportRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.entities.ClientEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.entities.OrderEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.entities.TransportEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.food_delivery.Client;
import es.upm.miw.apaw_practice.domain.models.food_delivery.Order;
import es.upm.miw.apaw_practice.domain.models.food_delivery.Transport;
import es.upm.miw.apaw_practice.domain.persistence_ports.food_delivery.TransportPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("transportPersistence")
public class TransportPersistenceMongodb implements TransportPersistence {

    private final TransportRepository transportRepository;

    private final ClientRepository clientRepository;

    @Autowired
    public TransportPersistenceMongodb(TransportRepository transportRepository, ClientRepository clientRepository) {
        this.transportRepository = transportRepository;
        this.clientRepository = clientRepository;
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

    @Override
    public Stream<String> findByEmailClient(String email) {
        return this.clientRepository.findAll().stream()
                .filter(client -> client.getEmail().equals(email))
                .flatMap(client -> client.getOrders().stream())
                .map(OrderEntity::getTransport)
                .map(TransportEntity::getLicensePlate);

    }
}
