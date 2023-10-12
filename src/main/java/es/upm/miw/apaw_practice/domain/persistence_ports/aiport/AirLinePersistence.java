package es.upm.miw.apaw_practice.domain.persistence_ports.aiport;

import es.upm.miw.apaw_practice.domain.models.airport.AirLine;
import es.upm.miw.apaw_practice.domain.models.airport.Aircraft;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AirLinePersistence {
    AirLine update(AirLine airLine);
}
