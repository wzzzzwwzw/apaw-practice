package es.upm.miw.apaw_practice.domain.services.library;

import es.upm.miw.apaw_practice.domain.persistence_ports.library.BookPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookPersistence bookPersistence;
    @Autowired
    public BookService(BookPersistence bookPersistence){
        this.bookPersistence = bookPersistence;
    }

    public void deleteByIsbn(String isbn){
        this.bookPersistence.deleteByIsbn(isbn);
    }
}
