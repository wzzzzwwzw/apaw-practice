package es.upm.miw.apaw_practice.domain.models.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BookWriterIT {
    @Test
    void testBookWriterBuilder() {
        BookWriter bookWriter = new BookWriter.Builder()
                .nickname("nickname of writer")
                .name("name of writer")
                .numberOfBook(2)
                .build();
        assertNotNull(bookWriter);
        assertEquals("nickname of writer", bookWriter.getNickname());
        assertEquals("name of writer", bookWriter.getName());
        assertEquals(2, bookWriter.getNumberOfBook());
    }
}
