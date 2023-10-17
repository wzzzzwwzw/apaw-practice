package es.upm.miw.apaw_practice.domain.services.library;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.library.LibrarySeederService;
import es.upm.miw.apaw_practice.domain.models.library.BookWriter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class BookWriterServiceIT {
    @Autowired
    private BookWriterService bookWriterService;
    @Autowired
    private LibrarySeederService librarySeederService;
    @AfterEach
    void resetDataBase(){
        this.librarySeederService.deleteAll();
        this.librarySeederService.seedDatabase();
    }
    @Test
    void testCreateBookWriter() {
        BookWriter bookWriter = this.bookWriterService.create(new BookWriter("Mo Yan", "M. Yan", 50));
        assertNotNull(bookWriter);
        assertEquals("Mo Yan", bookWriter.getName());
        assertEquals("M. Yan", bookWriter.getNickname());
        assertEquals(50, bookWriter.getNumberOfBook());
    }

    @Test
    void testUpdateNumberOfBook() {
        BookWriter bookWriter = this.bookWriterService.updateNumberOfBook("Cixin", 30);
        assertEquals("Cixin Liu", bookWriter.getName());
        assertEquals("Cixin", bookWriter.getNickname());
        assertEquals(30, bookWriter.getNumberOfBook());
        this.bookWriterService.updateNumberOfBook("Cixin",18);
    }
}
