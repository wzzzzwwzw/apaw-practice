package es.upm.miw.apaw_practice.adapters.mongodb.library.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.library.LibrarySeederService;
import es.upm.miw.apaw_practice.adapters.rest.library.dto.LoanDataDto;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.library.Book;
import es.upm.miw.apaw_practice.domain.models.library.Loan;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class LoanPersistenceMongodbIT {
    @Autowired
    private es.upm.miw.apaw_practice.adapters.mongodb.library.persistence.LoanPersistenceMongodb loanPersistenceMongodb;
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
        Loan loan = this.loanPersistenceMongodb.updateLoanStatusByLoanCode("EBO456", new LoanDataDto(LocalDateTime.now(), LocalDateTime.now().plusDays(7),true));
        assertNotNull(loan);
        assertEquals("9788413146454",loan.getBook().getIsbn());
        assertTrue(loan.getLoanDateTime().toLocalDate().isEqual(LocalDateTime.now().toLocalDate()));
        assertTrue(loan.getLoanStatus());
        assertTrue(loan.getReturnDateTime().isAfter(loan.getLoanDateTime()));
        assertTrue(loan.getReturnDateTime().toLocalDate().isEqual(loan.getLoanDateTime().toLocalDate().plusDays(7)));
    }

    @Test
    void testUpdateLoanStatusException(){
        assertThrows(NotFoundException.class, () -> this.loanPersistenceMongodb.updateLoanStatusByLoanCode("NotFoundCode", new LoanDataDto(null,null,null)));
    }

    @Test
    void testFindListOfBooksByLoanStatus(){
        List<Book> listOfBook = this.loanPersistenceMongodb.findAddressOfLibraryByLoanStatus(true);
        assertNotNull(listOfBook);
        assertEquals("9788401020414", listOfBook.get(0).getIsbn());
        assertEquals("9788416738090", listOfBook.get(1).getIsbn());
    }
}
