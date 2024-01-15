package es.upm.miw.apaw_practice.adapters.mongodb.library.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.LoanEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface LoanRepository extends MongoRepository<LoanEntity, String> {
    Optional<LoanEntity> findByLoanCode(String loanCode);
    Optional<List<LoanEntity>> findByLoanStatus(Boolean loanStatus);
}
