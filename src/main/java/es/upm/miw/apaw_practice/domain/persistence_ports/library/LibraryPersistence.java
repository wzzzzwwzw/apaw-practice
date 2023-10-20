package es.upm.miw.apaw_practice.domain.persistence_ports.library;

import es.upm.miw.apaw_practice.domain.models.library.Book;
import es.upm.miw.apaw_practice.domain.models.library.Library;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface LibraryPersistence {
    Library read(String name);
    BigDecimal findAverageOfNumberOfBookByLibraryName(String name);
    List<String> findAddressByBook(List<Book> listOfBook);
}
