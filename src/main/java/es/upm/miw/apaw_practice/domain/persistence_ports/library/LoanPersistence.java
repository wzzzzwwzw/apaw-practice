package es.upm.miw.apaw_practice.domain.persistence_ports.library;

import es.upm.miw.apaw_practice.adapters.rest.library.dto.LoanDataDto;
import es.upm.miw.apaw_practice.domain.models.library.Book;
import es.upm.miw.apaw_practice.domain.models.library.Loan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanPersistence {
    Loan updateLoanStatusByLoanCode(String loanCode, LoanDataDto loanDataDto);
    Loan readByLoanCode(String loanCode);

    List<Book> findAddressOfLibraryByLoanStatus(Boolean loanStatus);
}
