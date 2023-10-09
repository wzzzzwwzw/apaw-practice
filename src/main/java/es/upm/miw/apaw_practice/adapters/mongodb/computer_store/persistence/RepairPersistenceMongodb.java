package es.upm.miw.apaw_practice.adapters.mongodb.computer_store.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.daos.RepairRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.entities.RepairEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.computer_store.Repair;
import es.upm.miw.apaw_practice.domain.persistence_ports.computer_store.RepairPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository("repairPersistence")
public class RepairPersistenceMongodb implements RepairPersistence {
    private final RepairRepository repairRepository;

    @Autowired
    public RepairPersistenceMongodb(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }

    @Override
    public Repair updateEndTimeByRepairNumber(String repairNumber) {
        RepairEntity repair = this.repairRepository
                .findByRepairNumber(repairNumber)
                .orElseThrow(() -> new NotFoundException("Repair Number: " + repairNumber));
        repair.setEndTime(LocalDateTime.now());
        return this.repairRepository.save(repair).toRepair();
    }
}
