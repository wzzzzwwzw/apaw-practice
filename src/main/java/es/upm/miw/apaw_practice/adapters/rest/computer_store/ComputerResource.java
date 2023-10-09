package es.upm.miw.apaw_practice.adapters.rest.computer_store;

import es.upm.miw.apaw_practice.domain.services.computer_store.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ComputerResource.COMPUTERS)
public class ComputerResource {
    static final String COMPUTERS = "/computer-store/computers";
    static final String NAME_ID = "/{name}";
    @Autowired
    private final ComputerService computerService;

    public ComputerResource(ComputerService computerService) {
        this.computerService = computerService;
    }

    @DeleteMapping(NAME_ID)
    public void delete(@PathVariable String name) {
        this.computerService.delete(name);
    }
}
