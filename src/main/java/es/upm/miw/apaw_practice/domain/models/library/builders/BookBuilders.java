package es.upm.miw.apaw_practice.domain.models.library.builders;

import es.upm.miw.apaw_practice.domain.models.library.Book;
import es.upm.miw.apaw_practice.domain.models.library.BookWriter;

import java.time.LocalDate;
import java.util.List;

public interface BookBuilders {
    interface Isbn {
        Optionals isbn(String isbn);
    }

    interface Optionals{
        Optionals title(String title);
        Optionals publicationDate(LocalDate publicationDate);
        Optionals bookWriters(List<BookWriter> bookWriters);
        Book build();
    }
}
