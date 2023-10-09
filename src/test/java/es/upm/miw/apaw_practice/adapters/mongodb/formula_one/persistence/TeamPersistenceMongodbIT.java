package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@TestConfig
public class TeamPersistenceMongodbIT {

    @Autowired
    private TeamPersistenceMongodb teamPersistenceMongodb;

    @Test
    void testDelete() {
        this.teamPersistenceMongodb.delete("Mercedes");
    }
}
