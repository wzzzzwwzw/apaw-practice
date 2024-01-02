package es.upm.miw.apaw_practice.adapters.mongodb.library.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.BookEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.LibraryEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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
    @Test
    void testLibraryEntity(){
        assertTrue(this.libraryRepository.findByName("Biblioteca Nacional").isPresent());
        LibraryEntity library = this.libraryRepository.findByName("Biblioteca Nacional").get();
        LibraryEntity newLibrary = new LibraryEntity("Biblioteca","Calle",LocalDate.of(2000,10,20), library.getBookEntities());
        newLibrary.setName("Biblioteca test");
        assertEquals("Biblioteca test", newLibrary.getName());
        newLibrary.setAddress("Calle test");
        assertEquals("Calle test", newLibrary.getAddress());
        newLibrary.setFoundationDate(LocalDate.of(1999,1,1));
        assertEquals(LocalDate.of(1999,1,1), newLibrary.getFoundationDate());

        assertTrue(this.libraryRepository.findByName("Biblioteca territorial").isPresent());
        LibraryEntity anotherLibrary = this.libraryRepository.findByName("Biblioteca territorial").get();
        newLibrary.setBookEntities(anotherLibrary.getBookEntities());
        assertEquals(1, newLibrary.getBookEntities().size());
    }
}
