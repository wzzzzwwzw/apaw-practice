package es.upm.miw.apaw_practice.adapters.mongodb.library.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.library.BookWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class BookWriterPersistenceMongodbIT {
    @Autowired
    private BookWriterPersistenceMongodb bookWriterPersistence;

    @Test
    void testCreateAndRead(){
        BookWriter bookWriter =
                new BookWriter("Joanne Kathleen Rowling", "J.k. Rowling", 33);
        this.bookWriterPersistence.create(bookWriter);
        BookWriter bookWriterBD = this.bookWriterPersistence.read("J.k. Rowling");
        assertEquals("Joanne Kathleen Rowling", bookWriterBD.getName());
        assertEquals(33, bookWriterBD.getNumberOfBook());
    }

}
