package es.upm.miw.apaw_practice.adapters.mongodb.computer_store;

import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.daos.ComputerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.daos.MonitorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.daos.RepairRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.daos.WireRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.entities.ComputerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.entities.MonitorEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.entities.RepairEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.entities.WireEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

@Service
public class ComputerStoreSeederService {
    @Autowired
    private WireRepository wireRepository;
    @Autowired
    private MonitorRepository monitorRepository;
    @Autowired
    private ComputerRepository computerRepository;
    @Autowired
    private RepairRepository repairRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Computer Store Initial Load -----------");
        WireEntity[] wires = {
                new WireEntity("HDMI", new BigDecimal("1.5"), "Plastic"),
                new WireEntity("DisplayPort", new BigDecimal("3.5"), "Nylon"),
                new WireEntity("Power", new BigDecimal("1"), "Plastic"),
        };
        wireRepository.saveAll(Arrays.asList(wires));

        MonitorEntity[] monitors = {
                new MonitorEntity("MSIX001", new BigDecimal("27"), 144, Arrays.asList(wires[0], wires[2])),
                new MonitorEntity("XIAOMIC34001", new BigDecimal("34"), 165, Arrays.asList(wires))
        };
        monitorRepository.saveAll(Arrays.asList(monitors));

        ComputerEntity[] computers = {
                new ComputerEntity("MSI Pro gaming PC", new BigDecimal("1400"), new BigDecimal("6"), Collections.singletonList(monitors[0])),
                new ComputerEntity("Customized PC Bate Ye", new BigDecimal("1250"), new BigDecimal("8"), Collections.singletonList(monitors[1])),
                new ComputerEntity("Delete by rest computer", new BigDecimal("1340"), new BigDecimal("10"), Collections.singletonList(monitors[1]))
        };
        computerRepository.saveAll(Arrays.asList(computers));

        RepairEntity[] repairs = {
                new RepairEntity("1234", LocalDateTime.now(), LocalDateTime.now().plusDays(3), computers[0]),
                new RepairEntity("2234", LocalDateTime.now(), LocalDateTime.now().plusDays(2), computers[1]),
        };
        repairRepository.saveAll(Arrays.asList(repairs));
    }

    public void deleteAll() {
        this.repairRepository.deleteAll();
        this.computerRepository.deleteAll();
        this.monitorRepository.deleteAll();
        this.wireRepository.deleteAll();
    }
}
