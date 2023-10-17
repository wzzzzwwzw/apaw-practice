package es.upm.miw.apaw_practice.adapters.rest.library;

import es.upm.miw.apaw_practice.domain.models.library.Loan;
import es.upm.miw.apaw_practice.domain.services.library.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(LoanResource.LOAN)
public class LoanResource {
    static final String LOAN = "/library/loans";
    static final String LOAN_CODE_ID = "/{loanCode}";
    private final LoanService loanService;

    @Autowired
    public LoanResource(LoanService loanService){
        this.loanService = loanService;
    }

    @PatchMapping(LOAN_CODE_ID)
    public Loan updateLoanStatus(@PathVariable String loanCode){
        return this.loanService.updateLoanStatusByLoanCode(loanCode);
    }
}
