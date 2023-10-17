package es.upm.miw.apaw_practice.adapters.rest.aquarium;
import org.springframework.web.bind.annotation.*;
import es.upm.miw.apaw_practice.domain.models.aquarium.AquariumCurator;
import es.upm.miw.apaw_practice.domain.services.aquarium.AquariumCuratorService;
@RestController
@RequestMapping(AquariumCuratorResource.AquariumCurator)
public class AquariumCuratorResource {
    static final String AquariumCurator = "/aquariumCurators";
    static final String NAME = "/{name}";
    static final String POSITION = "/position";
    private final AquariumCuratorService aquariumCuratorService;

    public AquariumCuratorResource(AquariumCuratorService aquariumCuratorService){
        this.aquariumCuratorService = aquariumCuratorService;
    }
    @PutMapping(NAME+POSITION)
    public AquariumCurator updatePosition(@PathVariable String name,@RequestBody String position){
        return this.aquariumCuratorService.updatePosition(name,position);
    }
}
