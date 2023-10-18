package es.upm.miw.apaw_practice.adapters.rest.library;

import es.upm.miw.apaw_practice.domain.services.library.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BookResource.BOOKS)
public class BookResource {
    static final String BOOKS = "/library/books";
    static final String ISBN_ID = "/{isbn}";
    @Autowired
    private final BookService bookService;
    public BookResource(BookService bookService){
        this.bookService = bookService;
    }

    @DeleteMapping(ISBN_ID)
    public void delete(@PathVariable String isbn){
        this.bookService.deleteByIsbn(isbn);
    }
}
