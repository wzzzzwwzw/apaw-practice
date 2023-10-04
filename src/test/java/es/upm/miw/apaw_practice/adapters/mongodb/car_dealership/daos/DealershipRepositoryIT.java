package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.CarEntity;
import es.upm.miw.apaw_practice.domain.models.car_dealership.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class DealershipRepositoryIT {

    @Autowired
    private DealershipRepository dealershipRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.dealershipRepository.findAll().stream()
                .anyMatch(dealership ->
                        "Miña Car".equals(dealership.getName()) &&
                        dealership.getId() != null &&
                        "Malaga".equals(dealership.getCity()) &&
                        "Malaga".equals(dealership.getDistrict()) &&
                        3 == dealership.getCarEntities().size() &&
                        dealership.getCarEntities().stream()
                                .anyMatch(CarEntity ->
                                        "CP12-1237896142875".equals(CarEntity.getChassisNumber()))
                        ));
    }
}
