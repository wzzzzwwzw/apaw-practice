package es.upm.miw.apaw_practice.domain.services.library;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.library.LibrarySeederService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@TestConfig
public class BookServiceIT {
    @Autowired
    private BookService bookService;
    @Autowired
    private LibrarySeederService librarySeederService;
    @AfterEach
    void resetDataBaseAfter() {
        this.librarySeederService.deleteAll();
        this.librarySeederService.seedDatabase();
    }
    @BeforeEach
    void resetDataBaseBefore() {
        this.librarySeederService.deleteAll();
        this.librarySeederService.seedDatabase();
    }

    @Test
    void testDelete(){
        bookService.deleteByIsbn("9788416738090");
    }
}
