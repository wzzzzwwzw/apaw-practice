package es.upm.miw.apaw_practice.adapters.mongodb.subway.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.subway.entities.SubwayEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.mongodb.assertions.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class SubwayRepositoryIT {

    @Autowired
    private SubwayRepository subwayRepository;

    @Test
    void testFindByCity() {
        assertTrue(this.subwayRepository.findByCity("Madrid").isPresent());
        SubwayEntity subway = this.subwayRepository.findByCity("Madrid").get();
        assertEquals("Madrid", subway.getCity());
        assertFalse(this.subwayRepository.findByCity("Barcelona").isPresent());
    }

}
