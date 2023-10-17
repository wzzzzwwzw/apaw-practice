package es.upm.miw.apaw_practice.domain.persistence_ports.library;

import es.upm.miw.apaw_practice.domain.models.library.Loan;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanPersistence {
    Loan updateLoanStatusByLoanCode(String loanCode);
    Loan readByLoanCode(String loanCode);
}
