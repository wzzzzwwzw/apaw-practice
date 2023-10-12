package es.upm.miw.apaw_practice.domain.persistence_ports.computer_store;

import es.upm.miw.apaw_practice.domain.models.computer_store.Computer;
import es.upm.miw.apaw_practice.domain.models.computer_store.Repair;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RepairPersistence {
    Repair updateEndTimeByRepairNumber(String repairNumber);

    List<Computer> findComputersListByRepairDate(LocalDateTime date);
}
