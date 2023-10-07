package es.upm.miw.apaw_practice.domain.persistence_ports.computer_store;

import es.upm.miw.apaw_practice.domain.models.computer_store.Monitor;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorPersistence {
    Monitor updateRefreshRate(Monitor monitor);

    Monitor readBySerialNumber(String serialNumber);
}
