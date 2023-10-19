package es.upm.miw.apaw_practice.adapters.rest.bank;

import es.upm.miw.apaw_practice.domain.models.bank.Bank;
import es.upm.miw.apaw_practice.domain.services.bank.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(BankResource.BANKS)
public class BankResource {

    static final String BANKS="/bank_model/banks";

    static final String BANK_NAME="/{bankName}";

    static final String CAPITAL="/capital";

    private final BankService bankService;

    @Autowired
    public BankResource(BankService bankService){
        this.bankService=bankService;
    }

    @GetMapping(BANK_NAME)
    public Bank read(@PathVariable String bankName){
        return this.bankService.readByBankName(bankName);
    }

    @PostMapping
    public Bank create(@RequestBody Bank bank){
        return this.bankService.createBank(bank);
    }

    @PutMapping(BANK_NAME+CAPITAL)
    public Bank updateBankCapital(@PathVariable String bankName, @RequestBody BigDecimal capital){ return this.bankService.updateBankCapital(bankName,capital);}
}
