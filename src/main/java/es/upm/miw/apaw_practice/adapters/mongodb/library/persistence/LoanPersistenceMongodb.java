package es.upm.miw.apaw_practice.adapters.mongodb.library.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.library.daos.LoanRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.LoanEntity;
import es.upm.miw.apaw_practice.adapters.rest.library.dto.LoanDataDto;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.library.Loan;
import es.upm.miw.apaw_practice.domain.persistence_ports.library.LoanPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("loanPersistence")
public class LoanPersistenceMongodb implements LoanPersistence {
    private final LoanRepository loanRepository;
    @Autowired
    public LoanPersistenceMongodb(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan updateLoanStatusByLoanCode(String loanCode, LoanDataDto loanDataDto) {
        LoanEntity loanEntity = this.loanRepository
                .findByLoanCode(loanCode)
                .orElseThrow(() -> new NotFoundException("Loan code: " + loanCode));
        loanEntity.setLoanStatus(loanDataDto.getLoanStatus());
        loanEntity.setLoanDateTime(loanDataDto.getLoanDateTime());
        loanEntity.setReturnDateTime(loanDataDto.getReturnDateTime());
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
