package es.upm.miw.apaw_practice.adapters.mongodb.computer_store.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.computer_store.entities.ComputerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class ComputerRepositoryIT {
    @Autowired
    private ComputerRepository computerRepository;
    private static final String CUSTOMIZED_COMPUTER_NAME = "Customized PC Bate Ye";

    @Test
    void testComputerFindByName() {
        assertTrue(computerRepository.findByName(CUSTOMIZED_COMPUTER_NAME).isPresent());
        ComputerEntity computer = computerRepository.findByName(CUSTOMIZED_COMPUTER_NAME).get();
        assertEquals(new BigDecimal("1250"), computer.getCost());
        assertEquals(new BigDecimal("8"), computer.getWeight());
        assertTrue(
                computer.getMonitors().stream()
                        .anyMatch(monitor ->
                                monitor.getSerialNumber().equals("XIAOMIC34001") &&
                                        monitor.getRefreshRate() == 165 &&
                                        monitor.getSize().equals(new BigDecimal("34"))
                        )
        );
    }
}
