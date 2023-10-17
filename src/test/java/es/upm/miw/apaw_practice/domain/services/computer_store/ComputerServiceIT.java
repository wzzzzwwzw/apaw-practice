package es.upm.miw.apaw_practice.domain.services.computer_store;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class ComputerServiceIT {
    @Autowired
    private ComputerService computerService;

    @Test
    void testFindSumOfComputerCostByJacketMaterial() {
        BigDecimal result = this.computerService.findSumOfComputerCostByJacketMaterial("Plastic");
        assertEquals(new BigDecimal("3990"), result);
    }

    @Test
    void testZeroFindSumOfComputerCostByJacketMaterial() {
        BigDecimal result = this.computerService.findSumOfComputerCostByJacketMaterial("kk");
        assertEquals(BigDecimal.ZERO, result);
    }
}
