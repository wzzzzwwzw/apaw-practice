package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.Ingredient;
import es.upm.miw.apaw_practice.domain.services.restaurant.IngredientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(IngredientResource.INGREDIENTS)
public class IngredientResource {

    static final String INGREDIENTS = "restaurant/ingredients";
    static final String NAME_ID = "/{name}";

    private final IngredientService ingredientService;

    public IngredientResource(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping(NAME_ID)
    public Ingredient findByName(@PathVariable String name) {
        return this.ingredientService.findByName(name);
    }
}
