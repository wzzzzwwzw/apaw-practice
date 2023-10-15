package es.upm.miw.apaw_practice.adapters.mongodb.bakery.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.bakery.entities.TicketEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<TicketEntity, String> {
    
}