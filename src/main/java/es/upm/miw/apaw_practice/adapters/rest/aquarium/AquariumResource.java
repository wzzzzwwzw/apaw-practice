package es.upm.miw.apaw_practice.adapters.rest.aquarium;
import es.upm.miw.apaw_practice.domain.models.aquarium.Aquarium;
import es.upm.miw.apaw_practice.domain.services.aquarium.AquariumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AquariumResource.AQUARIUMS)
public class AquariumResource {
    static final String AQUARIUMS = "/Aquarium/aquariums";
    static final String DESCRIPTION = "/{description}";
    private final AquariumService aquariumService;
    @Autowired
    public AquariumResource(AquariumService aquariumService){
        this.aquariumService = aquariumService;
    }
    @GetMapping(DESCRIPTION)
    public Aquarium read(@PathVariable String description){
        return this.aquariumService.read(description);
    }
    @PostMapping
    public Aquarium create(@RequestBody Aquarium aquarium){
        return this.aquariumService.create(aquarium);
    }
}
