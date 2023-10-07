package es.upm.miw.apaw_practice.adapters.rest.computer_store;

import es.upm.miw.apaw_practice.domain.models.computer_store.Wire;
import es.upm.miw.apaw_practice.domain.services.computer_store.WireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(WireResource.WIRES)
public class WireResource {
    static final String WIRES = "/computer_store/wires";
    static final String NAME_ID = "/{name}";
    private final WireService wireService;
    @Autowired
    public WireResource(WireService wireService){
        this.wireService = wireService;
    }

    @GetMapping(NAME_ID)
    public Wire read(@PathVariable String name){
        return this.wireService.read(name);
    }

}
