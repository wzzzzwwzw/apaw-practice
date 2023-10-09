package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.PainterEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@TestConfig
public class PainterRepositoryIT {

    @Autowired
    private PainterRepository painterRepository;

    @Test
    void testCreateAndRead() {
        Assertions.assertTrue(this.painterRepository.findAll().stream()
                .anyMatch(painter ->
                               // new PainterEntity("Francisco de", "Goya y Lucientes", LocalDate.of(1746, 3, 30), LocalDate.of(1828, 4, 16), List.of(artWorks[2], artWorks[3], artWorks[6])),

                        "Francisco de".equals(painter.getName())
                        && "Goya y Lucientes".equals(painter.getSurname())
                        && LocalDate.of(1746, 3, 30).equals(painter.getBirthDate())
                        && LocalDate.of(1828, 4, 16).equals(painter.getDeathDate())
                        && 3 == painter.getArtWorks().size()
                        && painter.getArtWorks().stream().allMatch(artWorkEntity -> List.of("P000741", "P000742", "P000796").contains(artWorkEntity.getInventoryNumber()))
                ));
    }
}
