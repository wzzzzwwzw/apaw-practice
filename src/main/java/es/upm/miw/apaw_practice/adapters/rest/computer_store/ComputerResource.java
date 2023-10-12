package es.upm.miw.apaw_practice.adapters.rest.computer_store;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.services.computer_store.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(ComputerResource.COMPUTERS)
public class ComputerResource {
    static final String COMPUTERS = "/computer-store/computers";
    static final String NAME_ID = "/{name}";
    static final String SEARCH = "/search";
    @Autowired
    private final ComputerService computerService;

    public ComputerResource(ComputerService computerService) {
        this.computerService = computerService;
    }

    @DeleteMapping(NAME_ID)
    public void delete(@PathVariable String name) {
        this.computerService.delete(name);
    }

    @GetMapping(SEARCH)
    public BigDecimal findSumOfComputerCostByJacketMaterial(@RequestParam String q) {
        String jacketMaterial = new LexicalAnalyzer().extractWithAssure(q, "jacket-material");
        return this.computerService.findSumOfComputerCostByJacketMaterial(jacketMaterial);
    }
}
