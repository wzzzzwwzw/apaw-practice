package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtWorkEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@TestConfig
public class ArtWorkRepositoryIT {

    @Autowired
    private ArtWorkRepository artWorkRepository;

    @Test
    void testCreateAndRead() {
        Assertions.assertTrue(this.artWorkRepository.findAll().stream()
                .anyMatch(artWork ->
                        "P001174".equals(artWork.getInventoryNumber())
                        && "Las Meninas".equals(artWork.getTitle())
                        && 1656 == artWork.getApproximateYear()
                        && true == artWork.getExhibited()
                        && "Sala 012".equals(artWork.getRoom().getDescription())
                        && 1 == artWork.getRoom().getFloor()
                        && 9.75 == artWork.getRoom().getPopularity()
                ));
    }
}
