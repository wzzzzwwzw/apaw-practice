package es.upm.miw.apaw_practice.domain.services.school;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.school.School;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class SchoolServiceIT {

    @Autowired
    private SchoolService schoolService;

    @Test
    void testRead() {
        School school = this.schoolService.read("school1");
        assertEquals("address1", school.getAddress());
        assertEquals(LocalDate.of(2001, 3, 5), school.getOpeningDate());
        assertEquals(new BigDecimal("3000.00"), school.getRegistrationPrice());
        assertEquals("student1", school.getStudents().get(0).getName());
    }

    @Test
    void testRegistrationPriceSumGivenBilingual() {
        BigDecimal registrationPriceSum = this.schoolService.registrationPriceSumGivenBilingual(false);
        assertEquals(new BigDecimal("173.99"), registrationPriceSum);

        registrationPriceSum = this.schoolService.registrationPriceSumGivenBilingual(true);
        assertEquals(new BigDecimal("300.50"), registrationPriceSum);
    }
}
