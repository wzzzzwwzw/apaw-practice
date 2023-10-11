package es.upm.miw.apaw_practice.domain.services.formula_one;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@TestConfig
public class TeamServiceIT {

    @Autowired
    private TeamService teamService;

    @Test
    void testDelete() {
        this.teamService.delete("Aston Martin");
    }
}
