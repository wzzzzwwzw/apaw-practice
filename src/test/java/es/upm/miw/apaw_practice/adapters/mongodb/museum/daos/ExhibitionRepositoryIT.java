package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@TestConfig
class ExhibitionRepositoryIT {

    @Autowired
    private ExhibitionRepository exhibitionRepository;

    @Test
    void testCreateAndRead() {
        Assertions.assertTrue(this.exhibitionRepository.findAll().stream()
                .anyMatch(exhibition ->
                        "Pasiones mitológicas: Tiziano, Veronese, Allori, Rubens, Ribera, Poussin, Van Dyck, Velázquez".equals(exhibition.getExhibitionName())
                        && "Museo Nacional del Prado (Madrid, España)".equals(exhibition.getLocation())
                        && LocalDate.of(2021, 3, 2).equals(exhibition.getStartDate())
                        && LocalDate.of(2021, 7, 4).equals(exhibition.getEndDate())
                        && 2 == exhibition.getArtWorks().size()
                        && exhibition.getArtWorks().stream().allMatch(artWorkEntity -> List.of("P001173", "P001670").contains(artWorkEntity.getInventoryNumber()))
                ));
    }
}
