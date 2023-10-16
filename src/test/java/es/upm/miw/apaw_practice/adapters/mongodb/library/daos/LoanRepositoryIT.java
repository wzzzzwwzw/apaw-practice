package es.upm.miw.apaw_practice.adapters.mongodb.library.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class LoanRepositoryIT {
    @Autowired
    private LoanRepository loanRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.loanRepository.findAll().stream()
                .anyMatch(loan ->
                        "9788401020414".equals(loan.getBookEntity().getIsbn()) &&
                                loan.getLoanDateTime() != null &&
                                loan.getLoanDateTime().isBefore(loan.getReturnDateTime()) &&
                                loan.getReturnDateTime().isAfter(LocalDateTime.now()) &&
                                loan.getLoanStatus())
        );
    }
}
