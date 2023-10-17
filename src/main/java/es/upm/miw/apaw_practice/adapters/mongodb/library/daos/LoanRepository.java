package es.upm.miw.apaw_practice.adapters.mongodb.library.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.LoanEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LoanRepository extends MongoRepository<LoanEntity, String> {
    Optional<LoanEntity> findByLoanCode(String loanCode);
}
