package es.upm.miw.apaw_practice.domain.services.car_workshop;

import es.upm.miw.apaw_practice.domain.models.car_workshop.OBDFault;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class OBDFaultService {
    public Stream<OBDFault> findByIsITVSafe(Boolean b) {
        //TODO
        return null;
    }
}
