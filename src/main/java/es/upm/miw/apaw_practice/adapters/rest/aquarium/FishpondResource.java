package es.upm.miw.apaw_practice.adapters.rest.aquarium;
import es.upm.miw.apaw_practice.domain.services.aquarium.FishpondService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(FishpondResource.FISHPONDS)
public class FishpondResource {
    static final String FISHPONDS = "/aquarium/fishpond";
    static final String DIRECTION ="/{direction}";
    private final FishpondService fishpondService;

    public FishpondResource(FishpondService fishpondService) {
        this.fishpondService = fishpondService;
    }
    @DeleteMapping(DIRECTION)
    public void delete(@PathVariable String direction){
        this.fishpondService.delete(direction);
    }
}
