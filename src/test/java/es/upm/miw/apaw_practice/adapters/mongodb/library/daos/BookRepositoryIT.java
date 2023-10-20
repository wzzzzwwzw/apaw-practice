package es.upm.miw.apaw_practice.adapters.mongodb.library.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.library.LibrarySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.BookEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.BookWriterEntity;
import es.upm.miw.apaw_practice.domain.models.library.BookWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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
    @Test
    void testBookEntity(){
        assertTrue(this.bookRepository.findByIsbn("9788401020414").isPresent());
        BookEntity bookEntity = new BookEntity(this.bookRepository.findByIsbn("9788401020414").get().toBook());

        BookWriter bookWriter = new BookWriter("Mo Yan", "M.Yan",50);
        BookEntity newBookEntity = new BookEntity("El clan del SORGO ROJO","9788416523658", LocalDate.of(2016,11,2), List.of(new BookWriterEntity(bookWriter)));
        newBookEntity.setPublicationDate(LocalDate.of(2023,10,20));
        assertEquals(LocalDate.of(2023,10,20), newBookEntity.getPublicationDate());
        newBookEntity.setIsbn("8888888888888");
        assertEquals("8888888888888", newBookEntity.getIsbn());
        newBookEntity.setWriterEntities(List.of(new BookWriterEntity(new BookWriter("WriterName", "Writer",2))));
        assertEquals(1,newBookEntity.getBookWriterEntities().size());
        assertEquals("Writer", newBookEntity.getBookWriterEntities().get(0).getNickname());
    }
}
