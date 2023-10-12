package es.upm.miw.apaw_practice.adapters.rest.food_delivery;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.food_delivery.Transport;
import es.upm.miw.apaw_practice.domain.services.food_delivery.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(TransportResource.TRANSPORTS)
public class TransportResource {

    static final String TRANSPORTS = "/food_delivery/transports";

    static final String CODE_ID = "/{code}";
    static final String AVALAIBLE = "/avalaible";

    static final String SEARCH = "/search";
    private final TransportService transportService;

    @Autowired
    public TransportResource (TransportService transportservice){
        this.transportService = transportservice;
    }

    @PutMapping(CODE_ID + AVALAIBLE)
    public Transport updateTransportAvalaible(@PathVariable String code, @RequestBody Boolean avalaible) {
        return this.transportService.updateTransportAvalaible(code,avalaible);
    }

    @GetMapping(SEARCH)
    public Stream<String> findByEmailClient(@RequestParam String q){
        String email = new LexicalAnalyzer().extractWithAssure(q,"email");
        return this.transportService.findByEmailClient(email);
    }


}
