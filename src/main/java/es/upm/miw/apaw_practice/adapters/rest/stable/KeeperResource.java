package es.upm.miw.apaw_practice.adapters.rest.stable;

import es.upm.miw.apaw_practice.domain.models.stable.Keeper;
import es.upm.miw.apaw_practice.domain.services.stable.KeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(KeeperResource.KEEPERS)
public class KeeperResource {
    static final String KEEPERS = "/horse_stable/keepers";

    private final KeeperService keeperService;

    @Autowired
    public KeeperResource(KeeperService keeperService) {
        this.keeperService = keeperService;
    }

    @PostMapping
    public Keeper create(@RequestBody Keeper keeper) {
        return this.keeperService.create(keeper);
    }
}
