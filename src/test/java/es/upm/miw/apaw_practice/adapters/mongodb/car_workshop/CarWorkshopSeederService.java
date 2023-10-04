package es.upm.miw.apaw_practice.adapters.mongodb.car_workshop;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.daos.CarComponentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.daos.CarToRepairRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.daos.InvoiceRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.daos.OBDFaultRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.entities.CarComponentEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.entities.CarToRepairEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.entities.InvoiceEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.entities.OBDFaultEntity;
import es.upm.miw.apaw_practice.domain.models.car_workshop.CarComponent;
import es.upm.miw.apaw_practice.domain.models.car_workshop.OBDFault;

@Service
public class CarWorkshopSeederService {

    @Autowired
    private CarComponentRepository carComponentRepository;
    @Autowired
    private CarToRepairRepository carToRepairRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private OBDFaultRepository obdFaultRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Car Workshop Initial Load -----------");

        OBDFaultEntity[] obdFaultEntities = {
                new OBDFaultEntity(new OBDFault("P0001", "Fuel Volume Regulator Control Circuit/Open", true,
                        "Check the fuel cap, this is a common problem.")),
                new OBDFaultEntity(new OBDFault("P0002", "Fuel Volume Regulator Control Circuit Range/Performance",
                        false, "Check the fuel cap, this is a common problem.")),
                new OBDFaultEntity(new OBDFault("P0300", "CYLINDER MISFIRE", false, "Check sensors")),
                new OBDFaultEntity(new OBDFault("P0440", "EVAPORATIVE EMISSION SYSTEM LEAK", true, "Clean tank")),
        };

        this.obdFaultRepository.saveAll(Arrays.asList(obdFaultEntities));

        CarComponentEntity[] carComponentEntities = {
                new CarComponentEntity(new CarComponent("Universal Belt", new BigDecimal(20.0), 100)),
                new CarComponentEntity(new CarComponent("Air Filter", new BigDecimal(50.0), 200)),
                new CarComponentEntity(new CarComponent("Fog Lights", new BigDecimal(15.0), 300)),
                new CarComponentEntity(new CarComponent("Brake Pads", new BigDecimal(30.0), 50)),
                new CarComponentEntity(new CarComponent("Brake Discs", new BigDecimal(40.0), 50)),
        };

        this.carComponentRepository.saveAll(Arrays.asList(carComponentEntities));

        CarToRepairEntity[] carToRepairEntities = {
                new CarToRepairEntity("4567BBB", "Seat", "Ibiza", List.of(obdFaultEntities[0], obdFaultEntities[1])),
                new CarToRepairEntity("1234BGF", "Seat", "Leon", List.of(obdFaultEntities[2], obdFaultEntities[3])),
                new CarToRepairEntity("9876HJK", "Fiat", "Panda", List.of(obdFaultEntities[0], obdFaultEntities[1])),
                new CarToRepairEntity("7687FDR", "Dacia", "Sandero", List.of(obdFaultEntities[2], obdFaultEntities[3])),
        };

        this.carToRepairRepository.saveAll(Arrays.asList(carToRepairEntities));

        InvoiceEntity[] invoiceEntities = {
                new InvoiceEntity(LocalDateTime.now().minusDays(4), new BigDecimal(100.71), true,
                        carToRepairEntities[0], List.of(carComponentEntities[0], carComponentEntities[1])),
                new InvoiceEntity(LocalDateTime.now().minusMonths(3), new BigDecimal(50.72), true,
                        carToRepairEntities[1], List.of(carComponentEntities[2], carComponentEntities[3])),
                new InvoiceEntity(LocalDateTime.now().minusDays(22), new BigDecimal(45.73), true,
                        carToRepairEntities[2], List.of(carComponentEntities[4], carComponentEntities[0])),
                new InvoiceEntity(LocalDateTime.now().minusHours(6), new BigDecimal(120.74), false,
                        carToRepairEntities[3], List.of(carComponentEntities[1], carComponentEntities[2])),
        };

        this.invoiceRepository.saveAll(Arrays.asList(invoiceEntities));
    }

    public void deleteAll() {
        this.obdFaultRepository.deleteAll();
        this.carToRepairRepository.deleteAll();
        this.carComponentRepository.deleteAll();
        this.invoiceRepository.deleteAll();
    }
}
