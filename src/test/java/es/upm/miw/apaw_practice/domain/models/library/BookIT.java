package es.upm.miw.apaw_practice.domain.models.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookIT {
    @Test
    void testBookBuilder() {
        Book book = new Book.Builder()
                .isbn("9999999999999")
                .title("Titulo libro prueba")
                .publicationDate(LocalDate.of(2023, 10, 19))
                .bookWriters(List.of(new BookWriter.Builder()
                        .nickname("Wri")
                        .name("Writer")
                        .numberOfBook(1).build()))
                .build();
        assertNotNull(book);
        assertEquals("9999999999999", book.getIsbn());
        assertEquals("Titulo libro prueba", book.getTitle());
        assertEquals(LocalDate.of(2023, 10, 19), book.getPublicationDate());
        assertEquals(1, book.getBookWriters().get(0).getNumberOfBook());
        assertEquals("Writer", book.getBookWriters().get(0).getName());
        assertEquals("Wri", book.getBookWriters().get(0).getNickname());
    }
}
