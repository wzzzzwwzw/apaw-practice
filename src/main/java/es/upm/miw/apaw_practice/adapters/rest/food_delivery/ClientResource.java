package es.upm.miw.apaw_practice.adapters.rest.food_delivery;


import es.upm.miw.apaw_practice.domain.services.food_delivery.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ClientResource.CLIENTS)
public class ClientResource {

    static final String CLIENTS = "/food_delivery/clients";

    static final String IDENTITY_ID = "/{identity}";

    private final ClientService clientService;

    @Autowired
    public ClientResource(ClientService clientService) {
        this.clientService = clientService;

    }

    @DeleteMapping(IDENTITY_ID)
    public void delete(@PathVariable String identity){
        this.clientService.delete(identity);
    }


}
