package es.upm.miw.apaw_practice.domain.services.computer_store;

import es.upm.miw.apaw_practice.domain.models.computer_store.Monitor;
import es.upm.miw.apaw_practice.domain.persistence_ports.computer_store.MonitorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitorService {
    private final MonitorPersistence monitorPersistence;

    @Autowired
    public MonitorService(MonitorPersistence monitorPersistence) {
        this.monitorPersistence = monitorPersistence;
    }

    public Monitor updateRefreshRate(String serialNumber, Integer refreshRate) {
        Monitor monitor = this.monitorPersistence.readBySerialNumber(serialNumber);
        monitor.setRefreshRate(refreshRate);
        return this.monitorPersistence.updateRefreshRate(monitor);
    }
}
