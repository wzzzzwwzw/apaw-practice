package es.upm.miw.apaw_practice.domain.persistence_ports.computer_store;

import es.upm.miw.apaw_practice.domain.models.computer_store.Repair;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairPersistence {
    Repair updateEndTimeByRepairNumber(String repairNumber);
}
