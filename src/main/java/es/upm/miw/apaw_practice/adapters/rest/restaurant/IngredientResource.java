package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.restaurant.Ingredient;
import es.upm.miw.apaw_practice.domain.services.restaurant.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(IngredientResource.INGREDIENTS)
public class IngredientResource {

    static final String INGREDIENTS = "/restaurant/ingredients";
    static final String NAME_ID = "/{name}";
    static final String SEARCH = "/search";

    private final IngredientService ingredientService;

    @Autowired
    public IngredientResource(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping(NAME_ID)
    public Ingredient findByName(@PathVariable String name) {
        return this.ingredientService.findByName(name);
    }

    @GetMapping(SEARCH)
    public List<String> findAllIngredientNamesByCategoryColor(@RequestParam String q) {
        String color = new LexicalAnalyzer().extractWithAssure(q, "color");
        return this.ingredientService.findAllIngredientNamesByCategoryColor(color);
    }
}
