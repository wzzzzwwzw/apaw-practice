package es.upm.miw.apaw_practice.domain.services.zoo;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@TestConfig
public class ZooServiceIT {
    @Autowired
    private ZooService zooService;

    @Test
    void testDelete() {
        zooService.delete("ZOO MADRID");
    }


}
