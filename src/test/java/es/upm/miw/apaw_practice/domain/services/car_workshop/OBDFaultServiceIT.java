package es.upm.miw.apaw_practice.domain.services.car_workshop;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.car_workshop.OBDFault;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class OBDFaultServiceIT {

    @Autowired
    private OBDFaultService obdFaultService;

    @Test
    void testFindByIsITVSafe() {
        Stream<OBDFault> result = this.obdFaultService.findByIsITVSafe(false);
        assertEquals(result.toList().size(), 2);
    }
}
