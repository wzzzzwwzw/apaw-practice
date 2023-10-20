package es.upm.miw.apaw_practice.adapters.rest.school;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.school.School;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class SchoolResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testRead() {
        this.webTestClient
                .get()
                .uri(SchoolResource.SCHOOLS + SchoolResource.NAME_ID,
                        "school1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(School.class)
                .value(Assertions::assertNotNull)
                .value(schoolData -> {
                    assertEquals("school1", schoolData.getName());
                    assertEquals("address1", schoolData.getAddress());
                    assertEquals(LocalDate.of(2001, 3, 5), schoolData.getOpeningDate());
                    assertEquals(new BigDecimal("3000.00"), schoolData.getRegistrationPrice());
                    assertEquals("student1", schoolData.getStudents().get(0).getName());
                    assertEquals("subject1", schoolData.getStudents().get(0).getSubjects().get(0).getTitle());
                });
    }

    @Test
    void testRegistrationPriceSumGivenBilingual() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(SchoolResource.SCHOOLS + SchoolResource.REGISTRATION_PRICE_SUM_BY_BILINGUAL)
                                .queryParam("q", "bilingual:true")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(BigDecimal.class)
                .value(registrationPriceSum -> assertEquals(new BigDecimal("300.50"), registrationPriceSum));

        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(SchoolResource.SCHOOLS + SchoolResource.REGISTRATION_PRICE_SUM_BY_BILINGUAL)
                                .queryParam("q", "bilingual:false")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(BigDecimal.class)
                .value(registrationPriceSum -> assertEquals(new BigDecimal("173.99"), registrationPriceSum));
    }
}
