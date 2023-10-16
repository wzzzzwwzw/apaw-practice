package es.upm.miw.apaw_practice.domain.persistence_ports.aiport;

import es.upm.miw.apaw_practice.domain.models.airport.AirLine;
import org.springframework.stereotype.Repository;
@Repository
public interface AirLinePersistence {
    AirLine update(AirLine airLine);
    AirLine readByName(String name);
}
