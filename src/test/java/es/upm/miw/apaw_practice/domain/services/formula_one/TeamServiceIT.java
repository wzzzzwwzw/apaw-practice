package es.upm.miw.apaw_practice.domain.services.formula_one;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.formula_one.FormulaOneSeederService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@TestConfig
public class TeamServiceIT {

    @Autowired
    private TeamService teamService;
    @Autowired
    private FormulaOneSeederService formulaOneSeederService;

    @AfterEach
    void resetDataBase() {
        this.formulaOneSeederService.deleteAll();
        this.formulaOneSeederService.seedDatabase();
    }

    @Test
    void testDelete() {
        this.teamService.delete("Aston Martin");
    }
}
