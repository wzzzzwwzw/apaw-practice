package es.upm.miw.apaw_practice.adapters.rest.climbing;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.climbing.Expedition;
import es.upm.miw.apaw_practice.domain.services.climbing.ExpeditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(ExpeditionResource.EXPEDITIONS)
public class ExpeditionResource {
    static final String EXPEDITIONS = "/climbing/expeditions";
    static final String IDENTIFIER = "/{identifier}";
    static final String SEARCH = "/search";

    private final ExpeditionService expeditionService;

    @Autowired
    public ExpeditionResource(ExpeditionService expeditionService) {
        this.expeditionService = expeditionService;
    }

    @PostMapping
    public Expedition create(@RequestBody Expedition expedition) {
        expedition.doDefault();
        return this.expeditionService.create(expedition);
    }

    @PatchMapping(IDENTIFIER + "/total-expense")
    public Expedition updateTotalExpense(@PathVariable String identifier, @RequestBody BigDecimal totalExpense) {
        return this.expeditionService.updateTotalExpense(identifier, totalExpense);
    }

    @GetMapping(SEARCH)
    public BigDecimal findSumOfTotalExpenseByRouteDifficulty(@RequestParam String q) {
        String difficulty = new LexicalAnalyzer().extractWithAssure(q, "difficulty");
        return this.expeditionService.findSumOfTotalExpenseByRouteDifficulty(difficulty);
    }
}
