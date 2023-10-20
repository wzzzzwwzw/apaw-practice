package es.upm.miw.apaw_practice.adapters.mongodb.library.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.library.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class LibraryPersistenceMongodbIT {
    @Autowired
    private LibraryPersistenceMongodb libraryPersistence;

    @Test
    void testReadNotFound() {
        assertThrows(NotFoundException.class, () -> this.libraryPersistence.read("."));
    }

    @Test
    void testReadFound() {
        assertNotNull(this.libraryPersistence.read("Biblioteca universitaria"));
    }
    @Test
    void testFindNumberOfBookAverageByLibraryName(){
        assertEquals(new BigDecimal("20.50"), this.libraryPersistence.findAverageOfNumberOfBookByLibraryName("Biblioteca universitaria"));
    }
    @Test
    void testFindAddressByBook(){
        List<String> listAddress = new ArrayList<>();
        listAddress.add("Calle atocha 10");
        listAddress.add("Calle universidad 20");
        assertEquals(listAddress,this.libraryPersistence.findAddressByBook(List.of(new Book("Diarios de las canarias", "9788416738090", LocalDate.of(2017, 10, 4), null))));
    }
}
