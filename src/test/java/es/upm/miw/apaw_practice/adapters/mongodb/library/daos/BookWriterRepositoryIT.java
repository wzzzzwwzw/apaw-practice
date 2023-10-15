package es.upm.miw.apaw_practice.adapters.mongodb.library.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.BookWriterEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class BookWriterRepositoryIT {
    @Autowired
    private BookWriterRepository bookWriterRepository;

    @Test
    void testFindByNickname() {
        Optional<BookWriterEntity> write = this.bookWriterRepository.findByNickname("San Mao");
        assertTrue(this.bookWriterRepository.findByNickname("San Mao").isPresent());
        BookWriterEntity bookWriter = this.bookWriterRepository.findByNickname("San Mao").get();
        assertEquals("San Mao", bookWriter.getNickname());
        assertEquals("Echo Chen", bookWriter.getName());
        assertEquals(23, bookWriter.getNumberOfBook());
    }

}
