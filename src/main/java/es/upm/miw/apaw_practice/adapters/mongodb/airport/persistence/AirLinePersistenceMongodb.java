package es.upm.miw.apaw_practice.adapters.mongodb.airport.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.airport.daos.AirLineRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.AirLineEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.AircraftEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.entities.DriverEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.airport.AirLine;
import es.upm.miw.apaw_practice.domain.models.airport.Aircraft;
import es.upm.miw.apaw_practice.domain.persistence_ports.aiport.AirLinePersistence;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("airLinePersistence")
public class AirLinePersistenceMongodb implements AirLinePersistence {
    private final AirLineRepository airLineRepository;
    @Autowired
    public AirLinePersistenceMongodb(AirLineRepository airLineRepository){
        this.airLineRepository = airLineRepository;
    }
    @Override
    public AirLine readByName(String name){
        return this.airLineRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("AirLine with name: " + name))
                .toAirLine();
    }
    @Override
    public AirLine update(AirLine airLine) {
        AirLineEntity airLineEntity = this.airLineRepository
                .findByName(airLine.getName())
                .orElseThrow(()->new NotFoundException("AirLine with name: " + airLine.getName()));
        BeanUtils.copyProperties(airLine, airLineEntity, "aircrafts");
        List<AircraftEntity> aircraftEntityList = airLine.getAircrafts().stream()
                .map(aircraft -> {
                    AircraftEntity aircraftEntity = new AircraftEntity(aircraft);
                    return aircraftEntity;
                })
                .collect(Collectors.toList());
        airLineEntity.setAircrafts(aircraftEntityList);
        return this.airLineRepository
                .save(airLineEntity)
                .toAirLine();
    }
}
