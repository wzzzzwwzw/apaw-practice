package es.upm.miw.apaw_practice.domain.persistence_ports.car_workshop;

import es.upm.miw.apaw_practice.domain.models.car_workshop.OBDFault;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface OBDFaultPersistence {
    Stream<OBDFault> findByIsITVSafe(Boolean isITVSafe);
}
