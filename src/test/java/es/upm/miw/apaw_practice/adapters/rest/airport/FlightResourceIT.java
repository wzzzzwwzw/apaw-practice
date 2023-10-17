package es.upm.miw.apaw_practice.adapters.rest.airport;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.adapters.rest.conference.ConferenceLocationResource;
import es.upm.miw.apaw_practice.domain.models.airport.AirLine;
import es.upm.miw.apaw_practice.domain.models.airport.Aircraft;
import es.upm.miw.apaw_practice.domain.models.airport.Flight;
import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestTestConfig
public class FlightResourceIT {

    @Autowired
    private WebTestClient webTestClient;
    @Test
    void testCreate() {
        List<Passenger> passengerList = new ArrayList<>();
        List<Aircraft> aircraftList = new ArrayList<>();
        Integer numberOfFlight = 875858;
        AirLine airLine = new AirLine("Iberia", LocalDate.of(1927, 6, 28),aircraftList);
        Flight flight =
                new Flight(numberOfFlight, LocalDate.of(2023,10,10),passengerList, airLine);

        this.webTestClient
                .post()
                .uri(FlightResource.FLIGHTS)
                .body(BodyInserters.fromValue(flight))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Flight.class)
                .value(Assertions::assertNotNull);
    }

    @Test
    void testCreateConflict() {
        List<Passenger> passengerList = new ArrayList<>();
        List<Aircraft> aircraftList = new ArrayList<>();
        Integer numberOfFlight = 12345;
        AirLine airLine = new AirLine("Iberia", LocalDate.of(1927, 6, 28),aircraftList);
        Flight flight =
                new Flight(numberOfFlight, LocalDate.of(2023,10,10),passengerList, airLine);
        this.webTestClient
                .post()
                .uri(FlightResource.FLIGHTS)
                .body(BodyInserters.fromValue(flight))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }
    @Test
    void testFindAirlineNameByPassengerAgeGreaterThan() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(FlightResource.FLIGHTS + FlightResource.SEARCH_AIRLINE)
                                .queryParam("q", 70)
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .value(names -> Assertions.assertFalse(names.isEmpty()))
                .value(names -> Assertions.assertFalse(names.get(0).contains("Ryanair")))
                .value(names -> Assertions.assertTrue(names.get(0).contains("Iberia")));
    }

    @Test
    void testFindAverageAgeByModel() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(FlightResource.FLIGHTS + FlightResource.SEARCH_AGE)
                                .queryParam("q", "Airbus A320")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .value(names -> Assertions.assertFalse(names.isEmpty()))
                .value(names -> Assertions.assertEquals("48.0",names.get(0)));
    }

}
