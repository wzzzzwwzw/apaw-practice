package es.upm.miw.apaw_practice.domain.services.library;

import es.upm.miw.apaw_practice.domain.models.library.Loan;
import es.upm.miw.apaw_practice.domain.persistence_ports.library.LoanPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
    private final LoanPersistence loanPersistence;
    @Autowired
    public LoanService(LoanPersistence loanPersistence){
        this.loanPersistence = loanPersistence;
    }

    public Loan updateLoanStatusByLoanCode(String loanCode){
        return this.loanPersistence.updateLoanStatusByLoanCode(loanCode);
    }
}
