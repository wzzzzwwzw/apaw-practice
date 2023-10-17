package es.upm.miw.apaw_practice.domain.services.library;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.library.Library;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class LibraryServiceIT {
    @Autowired
    private LibraryService libraryService;
    @Test
    void testReadService(){
        Library library = this.libraryService.read("Biblioteca Nacional");
        assertNotNull(library);
        assertEquals("Calle atocha 10", library.getAddress());
        assertEquals(LocalDate.of(1996, 10, 1), library.getFoundationDate());
        assertEquals(2, library.getBooks().size());
        assertEquals("9788401020414", library.getBooks().get(0).getIsbn());
        assertEquals("9788416738090", library.getBooks().get(1).getIsbn());
    }
}
