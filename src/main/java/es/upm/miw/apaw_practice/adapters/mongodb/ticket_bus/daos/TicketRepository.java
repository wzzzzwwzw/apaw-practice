package es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.entities.TicketEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("TicketTRepository")
public interface TicketRepository extends MongoRepository<TicketEntity,String> {
}
