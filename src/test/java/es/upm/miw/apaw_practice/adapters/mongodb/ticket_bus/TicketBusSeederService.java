package es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus;

import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.daos.BusRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.daos.PassengerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.daos.TicketRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.daos.TripRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities.BusEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities.PassengerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities.TicketEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities.TripEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class TicketBusSeederService {

@Autowired
private BusRepository busRepository;
@Autowired
private  TicketRepository ticketRepository;
@Autowired
private PassengerRepository passengerRepository;
@Autowired
private TripRepository tripRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("-- Bus Ticket Initial Load --");
        PassengerEntity[] passengers = {
                new PassengerEntity("Y12345678", "wael louati", 24767211, false),
                new PassengerEntity("Y64548633", "Aria lop", 23047948, false)

        };
        this.passengerRepository.saveAll(Arrays.asList(passengers));
        TicketEntity[] tickets = {
                new TicketEntity("E1", "17:00", "18:00",
                        LocalDateTime.now(), new BigDecimal("10.00"), passengers[0]),
                new TicketEntity("E12", "17:00", "18:00",
                        LocalDateTime.now(), new BigDecimal("10.00"), passengers[0]),

        };
        this.ticketRepository.saveAll(Arrays.asList(tickets));
        TripEntity[] trips = {
                new TripEntity("Madrid-Toledo", "17:00"),
        };
        this.tripRepository.saveAll(Arrays.asList(trips));
        BusEntity[] buses = {
                new BusEntity("C-123", false, trips[0], List.of(passengers[0]))
        };
        this.busRepository.saveAll(Arrays.asList(buses));
    }

    public void deleteAll() {
        this.ticketRepository.deleteAll();
        this.passengerRepository.deleteAll();
        this.busRepository.deleteAll();
    }
}
