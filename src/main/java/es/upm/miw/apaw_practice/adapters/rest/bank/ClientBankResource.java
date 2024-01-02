package es.upm.miw.apaw_practice.adapters.rest.bank;

import es.upm.miw.apaw_practice.domain.models.bank.ClientBank;
import es.upm.miw.apaw_practice.domain.services.bank.ClientBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ClientBankResource.CLIENTS)
public class ClientBankResource {
    static final String CLIENTS="/bank_model/clients";

    static final String DNI="/{dni}";

    static final String SEARCH="/search";


    private final ClientBankService clientBankService;

    @Autowired
    public ClientBankResource(ClientBankService clientBankService){
        this.clientBankService=clientBankService;
    }
    @GetMapping(DNI)
    public ClientBank read(@PathVariable String dni){return this.clientBankService.read(dni);}
    @DeleteMapping(DNI)
    public void delete(@PathVariable String dni) {
        this.clientBankService.delete(dni);
    }

    @GetMapping(SEARCH)
    public List<String> findTypeNamesByDni(@RequestParam String dni ){
        return this.clientBankService.findTypeNamesByDni(dni);
    }
}
