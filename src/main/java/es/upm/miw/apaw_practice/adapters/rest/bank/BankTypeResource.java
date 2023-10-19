package es.upm.miw.apaw_practice.adapters.rest.bank;

import es.upm.miw.apaw_practice.domain.models.bank.BankType;
import es.upm.miw.apaw_practice.domain.services.bank.BankTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BankTypeResource.TYPES)
public class BankTypeResource {

    static final String TYPES="/bank_model/types";

    static final String TYPE_NAME="/{typeName}";

    private final BankTypeService bankTypeService;

    @Autowired
    public BankTypeResource(BankTypeService bankTypeService){
        this.bankTypeService=bankTypeService;
    }

    @GetMapping(TYPE_NAME)
    public BankType read(@PathVariable String typeName){
        return this.bankTypeService.read(typeName);
    }

}
