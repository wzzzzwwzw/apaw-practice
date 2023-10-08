package es.upm.miw.apaw_practice.adapters.rest.zoo;


import es.upm.miw.apaw_practice.domain.models.zoo.Animal;
import es.upm.miw.apaw_practice.domain.services.zoo.AnimalService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AnimalResource.ANIMALS)
public class AnimalResource {
    static final String ANIMALS = "/zoo/animals";
    static final String ID_IDENTIFICATION_CHIP = "/{identificationChip}";
    static final String AGE = "/age";
    private final AnimalService animalService;

    public AnimalResource(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PutMapping(ID_IDENTIFICATION_CHIP + AGE)
    public Animal putAge(@PathVariable String identificationChip, @RequestBody Integer age) {
        return this.animalService.updateAge(identificationChip, age);
    }
}
