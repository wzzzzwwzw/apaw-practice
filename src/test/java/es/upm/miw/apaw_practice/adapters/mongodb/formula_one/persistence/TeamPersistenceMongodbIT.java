package es.upm.miw.apaw_practice.adapters.mongodb.formula_one.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.FormulaOneSeederService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@TestConfig
public class TeamPersistenceMongodbIT {

    @Autowired
    private TeamPersistenceMongodb teamPersistenceMongodb;
    @Autowired
    private FormulaOneSeederService formulaOneSeederService;

    @AfterEach
    void resetDataBase() {
        this.formulaOneSeederService.deleteAll();
        this.formulaOneSeederService.seedDatabase();
    }

    @Test
    void testDelete() {
        this.teamPersistenceMongodb.delete("McLaren");
    }
}
