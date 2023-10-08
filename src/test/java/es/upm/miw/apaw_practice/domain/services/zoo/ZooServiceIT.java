package es.upm.miw.apaw_practice.domain.services.zoo;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.zoo.Vaccine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class ZooServiceIT {
    @Autowired
    private ZooService zooService;
    @Test
    void testDelete() {
        zooService.delete("PROTECTORA CANINA");
    }
}
