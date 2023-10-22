package es.upm.miw.apaw_practice.adapters.rest.bank;

import es.upm.miw.apaw_practice.adapters.rest.bank.dto.IncrementBalanceDto;
import es.upm.miw.apaw_practice.domain.models.bank.Bank;
import es.upm.miw.apaw_practice.domain.models.bank.BankAccount;
import es.upm.miw.apaw_practice.domain.services.bank.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(BankResource.BANKS)
public class BankResource {

    static final String BANKS="/bank_model/banks";

    static final String BANK_NAME="/{bankName}";



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


    @PatchMapping(BANK_NAME)
    public BankAccount updateIncreaseBankAccountBalance(@PathVariable String bankName,@RequestBody IncrementBalanceDto bodyIncrement){
        return this.bankService.updateIncreaseBankAccountBalance(bankName,bodyIncrement);
    }
}
