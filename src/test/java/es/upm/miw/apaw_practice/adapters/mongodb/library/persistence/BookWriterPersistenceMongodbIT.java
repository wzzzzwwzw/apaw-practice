package es.upm.miw.apaw_practice.adapters.mongodb.library.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.library.BookWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@TestConfig
public class BookWriterPersistenceMongodbIT {
    @Autowired
    private BookWriterPersistenceMongodb bookWriterPersistence;

    @Test
    void testCreateBook(){
        BookWriter bookWriter = this.bookWriterPersistence.create(new BookWriter("Joanne Kathleen Rowling", "J.k. Rowling", 33));
    }
}
