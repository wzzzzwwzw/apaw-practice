package es.upm.miw.apaw_practice.adapters.mongodb.library.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.library.LibrarySeederService;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.library.Loan;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class LoanPersistenceMongodbIT {
    @Autowired
    private LoanPersistenceMongodb loanPersistenceMongodb;
    @Autowired
    private BookPersistenceMongodb bookPersistenceMongodb;
    @Autowired
    private LibrarySeederService librarySeederService;

    @AfterEach
    void resetDatabase(){
        this.librarySeederService.deleteAll();
        this.librarySeederService.seedDatabase();
    }

    @Test
    void testUpdateLoanStatus(){
        Loan loan = this.loanPersistenceMongodb.updateLoanStatusByLoanCode("EBO456");
        assertNotNull(loan);
        assertEquals("9788413146454",loan.getBook().getIsbn());
        assertTrue(loan.getLoanDateTime().toLocalDate().isEqual(LocalDateTime.now().toLocalDate()));
        assertTrue(loan.getLoanStatus());
        assertTrue(loan.getReturnDateTime().isAfter(loan.getLoanDateTime()));
        assertTrue(loan.getReturnDateTime().isEqual(loan.getLoanDateTime().plusDays(7)));
    }

    @Test
    void testUpdateLoanStatusException(){
        assertThrows(NotFoundException.class, () -> this.loanPersistenceMongodb.updateLoanStatusByLoanCode("NotFoundCode"));
    }
}
