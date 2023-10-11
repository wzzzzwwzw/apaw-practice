package es.upm.miw.apaw_practice.adapters.rest.computer_store;

import es.upm.miw.apaw_practice.domain.models.computer_store.Wire;
import es.upm.miw.apaw_practice.domain.services.computer_store.WireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(WireResource.WIRES)
public class WireResource {
    static final String WIRES = "/computer-store/wires";
    static final String NAME_ID = "/{name}";
    private final WireService wireService;

    @Autowired
    public WireResource(WireService wireService) {
        this.wireService = wireService;
    }

    @GetMapping(NAME_ID)
    public Wire read(@PathVariable String name) {
        return this.wireService.read(name);
    }

    @PostMapping
    public Wire create(@RequestBody Wire wire) {
        return this.wireService.create(wire);
    }
}
