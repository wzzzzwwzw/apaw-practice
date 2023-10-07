package es.upm.miw.apaw_practice.adapters.mongodb.computer_store.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.daos.MonitorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.entities.MonitorEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.computer_store.Monitor;
import es.upm.miw.apaw_practice.domain.persistence_ports.computer_store.MonitorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("monitorPersistence")
public class MonitorPersistenceMongodb implements MonitorPersistence {
    private final MonitorRepository monitorRepository;

    @Autowired
    public MonitorPersistenceMongodb(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    @Override
    public Monitor updateRefreshRate(Monitor monitor) {
        MonitorEntity monitorEntity = this.monitorRepository
                .findBySerialNumber(monitor.getSerialNumber())
                .orElseThrow(() -> new NotFoundException("Monitor serial number: " + monitor.getSerialNumber()));
        monitorEntity.setRefreshRate(monitor.getRefreshRate());
        return this.monitorRepository.save(monitorEntity).toMonitor();
    }

    @Override
    public Monitor readBySerialNumber(String serialNumber) {
        return this.monitorRepository
                .findBySerialNumber(serialNumber)
                .orElseThrow(() -> new NotFoundException("Monitor serial number: " + serialNumber))
                .toMonitor();
    }
}
