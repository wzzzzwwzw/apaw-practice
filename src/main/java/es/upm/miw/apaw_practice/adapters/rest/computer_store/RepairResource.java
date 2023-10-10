package es.upm.miw.apaw_practice.adapters.rest.computer_store;

import es.upm.miw.apaw_practice.domain.models.computer_store.Repair;
import es.upm.miw.apaw_practice.domain.services.computer_store.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RepairResource.REPAIRS)
public class RepairResource {
    static final String REPAIRS = "/computer-store/repairs";
    static final String REPAIR_NUMBER_ID = "/{repairNumber}";

    private final RepairService repairService;

    @Autowired
    public RepairResource(RepairService repairService) {
        this.repairService = repairService;
    }

    @PatchMapping(REPAIR_NUMBER_ID)
    public Repair updateRepairEndTime(@PathVariable String repairNumber) {
        return this.repairService.updateEndTimeByRepairNumber(repairNumber);
    }
}
