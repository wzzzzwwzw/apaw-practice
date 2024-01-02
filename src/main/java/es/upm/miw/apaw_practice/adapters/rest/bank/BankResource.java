package es.upm.miw.apaw_practice.adapters.rest.bank;


import es.upm.miw.apaw_practice.domain.models.bank.Bank;
import es.upm.miw.apaw_practice.domain.models.bank.BankAccount;
import es.upm.miw.apaw_practice.domain.services.bank.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(BankResource.BANKS)
public class BankResource {

    static final String BANKS="/bank_model/banks";

    static final String BANK_NAME="/{bankName}";

    static final String ACCOUNTS="/accounts";
    static final String NUM_ACCOUNT="/{numAccount}";

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

    @PutMapping(BANK_NAME)
    public Bank updateBank(@PathVariable String bankName, @RequestBody Bank bank){ return this.bankService.updateBank(bankName,bank);}


    @PatchMapping(BANK_NAME+ACCOUNTS+NUM_ACCOUNT)
    public BankAccount updateIncreaseBankAccountBalance(@PathVariable String bankName,@PathVariable String numAccount,@RequestBody BigDecimal increment){
        return this.bankService.updateIncreaseBankAccountBalance(bankName,numAccount,increment);
    }
}
