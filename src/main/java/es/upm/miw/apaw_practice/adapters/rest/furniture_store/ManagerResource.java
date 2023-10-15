package es.upm.miw.apaw_practice.adapters.rest.furniture_store;

import es.upm.miw.apaw_practice.domain.services.furniture_store.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ManagerResource.MANAGER)
public class ManagerResource {

    static final String MANAGER = "/furniture-store/managers";

    static final String NAME_ID = "/{name}";

    private final ManagerService managerService;

    @Autowired
    public ManagerResource(ManagerService managerService) {
        this.managerService = managerService;
    }

    @DeleteMapping(NAME_ID)
    public void delete(@PathVariable String name) {
        this.managerService.delete(name);
    }

}
