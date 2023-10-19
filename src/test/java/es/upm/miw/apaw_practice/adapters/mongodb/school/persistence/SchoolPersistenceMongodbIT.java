package es.upm.miw.apaw_practice.adapters.mongodb.school.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.school.School;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class SchoolPersistenceMongodbIT {

    @Autowired
    private SchoolPersistenceMongodb schoolPersistenceMongodb;

    @Test
    void testRead() {
        School school = this.schoolPersistenceMongodb.read("school1");
        assertEquals("school1", school.getName());
        assertEquals("address1", school.getAddress());
        assertEquals(LocalDate.of(2001, 3, 5), school.getOpeningDate());
        assertEquals(new BigDecimal("3000.00"), school.getRegistrationPrice());
        assertEquals("student1", school.getStudents().get(0).getName());
        assertEquals("subject1", school.getStudents().get(0).getSubjects().get(0).getTitle());
    }

    @Test
    void registrationPriceSumGivenBilingual() {
        assertEquals(new BigDecimal("300.50"), this.schoolPersistenceMongodb.registrationPriceSumGivenBilingual(true));
        assertEquals(new BigDecimal("173.99"), this.schoolPersistenceMongodb.registrationPriceSumGivenBilingual(false));
    }
}
