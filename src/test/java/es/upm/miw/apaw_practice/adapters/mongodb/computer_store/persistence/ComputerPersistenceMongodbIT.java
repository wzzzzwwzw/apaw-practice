package es.upm.miw.apaw_practice.adapters.mongodb.computer_store.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.computer_store.Computer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
class ComputerPersistenceMongodbIT {
    @Autowired
    private ComputerPersistenceMongodb computerPersistenceMongodb;

    @Test
    void testFindComputersStreamByJacketMaterial() {
        Stream<Computer> computerStream = this.computerPersistenceMongodb.findComputersStreamByJacketMaterial("Plastic");
        assertNotNull(computerStream);
        assertEquals(3, computerStream.count());
    }

    @Test
    void testNotFindComputersStreamByJacketMaterial() {
        Stream<Computer> computerStream = this.computerPersistenceMongodb.findComputersStreamByJacketMaterial("kk");
        assertNotNull(computerStream);
        assertEquals(0, computerStream.count());
    }
}
