package es.upm.miw.apaw_practice.adapters.mongodb.library.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.library.LibrarySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.BookEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.BookWriterEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class BookRepositoryIT {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LibrarySeederService librarySeederService;
    @BeforeEach
    void cleanUpDB(){
        this.librarySeederService.deleteAll();
        this.librarySeederService.seedDatabase();
    }
    @Test
    void testFindByIsbn(){
        assertTrue(this.bookRepository.findByIsbn("9788401020414").isPresent());
        BookEntity book = this.bookRepository.findByIsbn("9788401020414").get();
        assertEquals("Bellas durmientes", book.getTitle());
        assertEquals(LocalDate.of(2018, 2, 1), book.getPublicationDate());
        assertTrue(book.getBookWriterEntities().stream()
                .map(BookWriterEntity::getNickname)
                .toList()
                .containsAll(Arrays.asList("Owen", "Stephen")));
    }

    @Test
    void testBookDeleteByIsbn(){
        this.bookRepository.deleteByIsbn("9788466659734");
        assertFalse(this.bookRepository.findByIsbn("9788466659734").isPresent());
    }
}
