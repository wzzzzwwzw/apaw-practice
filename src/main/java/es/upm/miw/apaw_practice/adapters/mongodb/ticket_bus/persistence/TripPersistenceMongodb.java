package es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.daos.TripRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities.TicketEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities.TripEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.ticket_bus.Trip;
import es.upm.miw.apaw_practice.domain.persistence_ports.ticket_bus.TripPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository("tripPersistence")
public class TripPersistenceMongodb implements TripPersistence {
    private final TripRepository tripRepository;

    @Autowired
    public TripPersistenceMongodb(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public Trip readByPath(String path) {
        return this.tripRepository.findByPath(path)
                .orElseThrow(() -> new NotFoundException("Trip path: " + path))
                .toTrip();
    }

    @Override
    public BigDecimal getSumOfTicketPricesByTripPath(String path) {
        TripEntity tripEntity = this.tripRepository.findByPath(path)
                .orElseThrow(() -> new NotFoundException("Trip path: " + path));

        List<TicketEntity> tickets = tripEntity.getTickets();
        BigDecimal totalPrice = BigDecimal.ZERO;

        for (TicketEntity ticket : tickets) {
            totalPrice = totalPrice.add(ticket.getPrice());
        }

        return totalPrice;
    }
}
