package es.upm.miw.apaw_practice.adapters.mongodb.swimming.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.swimming.entities.ApprenticeEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class ApprenticeRepositoryIT {

    @Autowired
    private ApprenticeRepository apprenticeRepository;
    private static final String FORENAME = "Maximilian Ramos";

    @Test
    void testFindByForeName(){
        assertTrue(this.apprenticeRepository.findByForeName(FORENAME).isPresent());
        ApprenticeEntity apprentice = this.apprenticeRepository.findByForeName(FORENAME).get();
        assertEquals(FORENAME, apprentice.getForeName());
        assertEquals(2, apprentice.getAge());
        assertEquals("Madrid", apprentice.getAddress());
        assertEquals(1, apprentice.getInscriptionEntities().size());

        assertTrue(apprentice.getInscriptionEntities().stream()
                .anyMatch( inscription ->
                        inscription.getRecordDate().isBefore(LocalDateTime.now()) &&
                                inscription.getAsset()
                ));
    }

}
