package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class DrivingStyleRepositoryIT {

    @Autowired
    private DrivingStyleRepository drivingStyleRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.drivingStyleRepository.findAll().stream()
                .anyMatch(drivingStyle ->
                        (90 == drivingStyle.getAggressiveness()) &&
                                (97 == drivingStyle.getConsistency()) &&
                                (95 == drivingStyle.getAdaptability()) &&
                                (90 == drivingStyle.getTireManagement()) &&
                                (90 == drivingStyle.getFuelManagement())
                ));
    }
}
