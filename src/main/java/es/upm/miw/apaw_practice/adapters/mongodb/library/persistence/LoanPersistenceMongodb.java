package es.upm.miw.apaw_practice.adapters.mongodb.library.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.library.daos.LoanRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.LoanEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.library.Loan;
import es.upm.miw.apaw_practice.domain.persistence_ports.library.LoanPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository("loanPersistence")
public class LoanPersistenceMongodb implements LoanPersistence {
    private final LoanRepository loanRepository;
    @Autowired
    public LoanPersistenceMongodb(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan updateLoanStatusByLoanCode(String loanCode) {
        LoanEntity loanEntity = this.loanRepository
                .findByLoanCode(loanCode)
                .orElseThrow(() -> new NotFoundException("Loan code: " + loanCode));
        loanEntity.setLoanStatus(true);
        loanEntity.setLoanDateTime(LocalDateTime.now());
        loanEntity.setReturnDateTime(loanEntity.getLoanDateTime().plusDays(7));
        return this.loanRepository.save(loanEntity).toLoan();
    }

    @Override
    public Loan readByLoanCode(String loanCode){
        return this.loanRepository
                .findByLoanCode(loanCode)
                .orElseThrow(() -> new NotFoundException("Loan code: " + loanCode))
                .toLoan();
    }
}
