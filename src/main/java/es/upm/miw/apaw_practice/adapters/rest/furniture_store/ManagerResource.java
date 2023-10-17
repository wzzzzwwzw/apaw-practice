package es.upm.miw.apaw_practice.adapters.rest.furniture_store;

import es.upm.miw.apaw_practice.domain.services.furniture_store.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ManagerResource.MANAGER)
public class ManagerResource {

    static final String MANAGER = "/furniture-store/managers";

    static final String AFFILIATION_NUMBER_ID = "/{affiliationNumber}";

    private final ManagerService managerService;

    @Autowired
    public ManagerResource(ManagerService managerService) {
        this.managerService = managerService;
    }

    @DeleteMapping(AFFILIATION_NUMBER_ID)
    public void delete(@PathVariable String affiliationNumber) {
        this.managerService.delete(affiliationNumber);
    }

}
