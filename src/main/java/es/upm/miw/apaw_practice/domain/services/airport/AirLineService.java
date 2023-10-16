package es.upm.miw.apaw_practice.domain.services.airport;

import es.upm.miw.apaw_practice.domain.models.airport.AirLine;
import es.upm.miw.apaw_practice.domain.models.airport.Aircraft;
import es.upm.miw.apaw_practice.domain.persistence_ports.aiport.AirLinePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirLineService {
    private final AirLinePersistence airLinePersistence;
    @Autowired
    public AirLineService(AirLinePersistence airLinePersistence){
        this.airLinePersistence = airLinePersistence;
    }
    public AirLine updateAircrafts(String name, List<Aircraft> aircraftList){
        AirLine airLine = this.airLinePersistence.readByName(name);
        airLine.setAircrafts(aircraftList);
        return this.airLinePersistence.update(airLine);
    }
}
