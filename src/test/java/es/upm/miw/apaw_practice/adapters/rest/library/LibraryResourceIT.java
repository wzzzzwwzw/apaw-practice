package es.upm.miw.apaw_practice.adapters.rest.library;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.library.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
class LibraryResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testGetByName() {
        this.webTestClient
                .get()
                .uri(LibraryResource.LIBRARY + LibraryResource.NAME_ID, "Biblioteca universitaria")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Library.class)
                .value(Assertions::assertNotNull)
                .value(libraryData -> {
                    assertEquals("Calle universidad 20", libraryData.getAddress());
                    assertEquals(LocalDate.of(1980, 1, 9), libraryData.getFoundationDate());
                    assertEquals(3, libraryData.getBooks().size());
                    assertEquals("9788413146454", libraryData.getBooks().get(0).getIsbn());
                    assertEquals("9788416738090", libraryData.getBooks().get(1).getIsbn());
                    assertEquals("9788466659734", libraryData.getBooks().get(2).getIsbn());
                });
    }

    @Test
    void testFindAddressOfLibraryByLoanStatus() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(LibraryResource.LIBRARY + LibraryResource.SEARCH)
                                .queryParam("q", "loanStatus:false")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .value(Assertions::assertNotNull)
                .value(addressList -> {
                    assertEquals(1, addressList.size());
                    assertTrue(addressList.get(0).contains("Calle universidad 20"));
                });
    }

}
