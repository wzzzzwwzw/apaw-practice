package es.upm.miw.apaw_practice.adapters.mongodb.museum.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.museum.Painter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class PainterPersistenceMongodbIT {

    @Autowired
    private PainterPersistenceMongodb painterPersistenceMongodb;

    @Test
    void testReadFound() {
        Painter painter = new Painter("Diego Rodríguez de Silva y", "Velázquez",LocalDate.of(1599, 6, 6), LocalDate.of(1660, 8, 6), List.of());
        Painter foundPainter = this.painterPersistenceMongodb.findBySurname("Velázquez");
        assertEquals(painter.getSurname(), foundPainter.getSurname());
    }

    @Test
    void testReadNotFound() {
        assertThrows(NotFoundException.class, () -> this.painterPersistenceMongodb.findBySurname("Zurbarán"));
    }

    @Test
    void readAndUpdate() {
        Painter foundPainter = this.painterPersistenceMongodb.findBySurname("Velázquez");

        foundPainter.setName("Diego");
        foundPainter.setDeathDate(LocalDate.of(1660, 8, 7));
        foundPainter.setArtWorks(foundPainter.getArtWorks().subList(0, 1));
        Painter updatedPainter = this.painterPersistenceMongodb.update(foundPainter);

        assertEquals("Diego", updatedPainter.getName());
        assertEquals(LocalDate.of(1660, 8, 7), updatedPainter.getDeathDate());
        assertEquals(1, updatedPainter.getArtWorks().size());
    }

    @Test
    void readAndBadUpdate() {
        Painter foundPainter = this.painterPersistenceMongodb.findBySurname("Velázquez");

        foundPainter.setSurname("Velázquez con otro apellido");

        assertThrows(NotFoundException.class, () -> this.painterPersistenceMongodb.update(foundPainter));
    }
}
