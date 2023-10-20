package es.upm.miw.apaw_practice.domain.models.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class TreeBooksTest {
    @Test
    void testTreeBooksComposite(){
        BooksComposite booksComposite = new BooksComposite("Kailas Editorial");
        Assertions.assertTrue(booksComposite.isComposite());

        Book book = new Book("El clan del SORGO ROJO","9788416523658", LocalDate.of(2016,11,2), List.of(new BookWriter("Mo Yan", "M.Yan",50)));

        booksComposite.add(book);
        Assertions.assertEquals(1, booksComposite.number());
        Assertions.assertTrue(booksComposite.isComposite());

        booksComposite.remove(book);
        Assertions.assertEquals(0, booksComposite.number());
        Assertions.assertTrue(booksComposite.isComposite());
    }

    @Test
    void testTreeBooksLeaf(){
        Book book = new Book("La vida y la muerte me están desgastando","9788416023134", LocalDate.of(2009,5,6), List.of(new BookWriter("Mo Yan", "M.Yan",50)));
        Assertions.assertFalse(book.isComposite());
        Assertions.assertThrows(UnsupportedOperationException.class, () -> book.add(book));
    }
}
