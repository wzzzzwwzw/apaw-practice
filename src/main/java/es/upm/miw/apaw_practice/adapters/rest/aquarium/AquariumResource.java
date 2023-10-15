package es.upm.miw.apaw_practice.adapters.rest.aquarium;
import es.upm.miw.apaw_practice.domain.models.aquarium.Aquarium;
import es.upm.miw.apaw_practice.domain.services.aquarium.AquariumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
