package es.upm.miw.apaw_practice.adapters.mongodb.library.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.BookEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.LibraryEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class LibraryRepositoryIT {
    @Autowired
    private LibraryRepository libraryRepository;

    @Test
    void testFindByName() {
        assertTrue(this.libraryRepository.findByName("Biblioteca Nacional").isPresent());
        LibraryEntity library = this.libraryRepository.findByName("Biblioteca Nacional").get();
        assertEquals("Biblioteca Nacional", library.getName());
        assertEquals("Calle atocha 10", library.getAddress());
        assertEquals(LocalDate.of(1996, 10, 1), library.getFoundationDate());
        assertTrue(library.getBookEntities().stream()
                .map(BookEntity::getIsbn)
                .toList()
                .containsAll(Arrays.asList("9788401020414", "9788416738090")));
    }
}
