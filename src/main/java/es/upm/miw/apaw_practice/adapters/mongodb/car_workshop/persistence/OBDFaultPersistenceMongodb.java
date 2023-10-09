package es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.daos.OBDFaultRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.entities.OBDFaultEntity;
import es.upm.miw.apaw_practice.domain.models.car_workshop.OBDFault;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_workshop.OBDFaultPersistence;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("OBDFaultPersistence")
public class OBDFaultPersistenceMongodb implements OBDFaultPersistence {

    private final OBDFaultRepository obdFaultRepository;

    public OBDFaultPersistenceMongodb(OBDFaultRepository obdFaultRepository) {
        this.obdFaultRepository = obdFaultRepository;
    }

    @Override
    public Stream<OBDFault> findByIsITVSafe(Boolean isITVSafe) {
        return this.obdFaultRepository.findAll().stream()
                .filter(obdFaultEntity -> obdFaultEntity.getIsITVSafe().equals(isITVSafe))
                .map(OBDFaultEntity::toOBDFault);
    }
}
