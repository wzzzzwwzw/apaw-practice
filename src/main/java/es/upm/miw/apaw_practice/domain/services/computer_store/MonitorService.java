package es.upm.miw.apaw_practice.domain.services.computer_store;

import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.computer_store.Computer;
import es.upm.miw.apaw_practice.domain.models.computer_store.Monitor;
import es.upm.miw.apaw_practice.domain.persistence_ports.computer_store.MonitorPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.computer_store.RepairPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MonitorService {
    private final MonitorPersistence monitorPersistence;
    private final RepairPersistence repairPersistence;

    @Autowired
    public MonitorService(MonitorPersistence monitorPersistence, RepairPersistence repairPersistence) {
        this.monitorPersistence = monitorPersistence;
        this.repairPersistence = repairPersistence;
    }

    public Monitor updateRefreshRate(String serialNumber, Integer refreshRate) {
        Monitor monitor = this.monitorPersistence.readBySerialNumber(serialNumber);
        monitor.setRefreshRate(refreshRate);
        return this.monitorPersistence.updateRefreshRate(monitor);
    }

    public List<String> findSerialNumberByDateAndCost(LocalDateTime date, BigDecimal cost) {
        List<Computer> computerList = this.repairPersistence.findComputersListByRepairDate(date);
        if (computerList.isEmpty()) {
            throw new NotFoundException(MessageFormat.format("No serial numbers was founded for date: {0} and computer cost greater than: {1}", date, cost));
        }
        return computerList
                .stream()
                .filter(computer -> computer
                        .getCost()
                        .compareTo(cost) > 0)
                .flatMap(computer -> computer
                        .getMonitors()
                        .stream())
                .distinct()
                .map(Monitor::getSerialNumber)
                .toList();
    }
}
