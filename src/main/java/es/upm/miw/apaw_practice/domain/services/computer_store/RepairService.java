package es.upm.miw.apaw_practice.domain.services.computer_store;

import es.upm.miw.apaw_practice.domain.models.computer_store.Repair;
import es.upm.miw.apaw_practice.domain.persistence_ports.computer_store.RepairPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepairService {
    private final RepairPersistence repairPersistence;

    @Autowired
    public RepairService(RepairPersistence repairPersistence) {
        this.repairPersistence = repairPersistence;
    }

    public Repair updateEndTimeByRepairNumber(String repairNumber) {
        return this.repairPersistence.updateEndTimeByRepairNumber(repairNumber);
    }
}
