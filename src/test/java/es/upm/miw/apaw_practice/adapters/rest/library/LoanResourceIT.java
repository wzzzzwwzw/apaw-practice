package es.upm.miw.apaw_practice.adapters.rest.library;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.adapters.rest.library.dto.LoanDataDto;
import es.upm.miw.apaw_practice.domain.models.library.Loan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
public class LoanResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testPatchEndPoint(){
        this.webTestClient
                .patch()
                .uri(LoanResource.LOAN + LoanResource.LOAN_CODE_ID, "EPLTC111")
                .body(BodyInserters.fromValue(new LoanDataDto(LocalDateTime.now(), LocalDateTime.now().plusDays(7), true)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Loan.class)
                .value(Assertions::assertNotNull)
                .value(loan -> {
                    assertEquals("EPLTC111", loan.getLoanCode());
                    assertEquals("9788466659734",loan.getBook().getIsbn());
                    assertTrue(loan.getLoanDateTime().toLocalDate().isEqual(LocalDateTime.now().toLocalDate()));
                    assertTrue(loan.getLoanStatus());
                    assertTrue(loan.getReturnDateTime().isAfter(loan.getLoanDateTime()));
                    assertTrue(loan.getReturnDateTime().toLocalDate().isEqual(loan.getLoanDateTime().toLocalDate().plusDays(7)));
                });
    }
}
