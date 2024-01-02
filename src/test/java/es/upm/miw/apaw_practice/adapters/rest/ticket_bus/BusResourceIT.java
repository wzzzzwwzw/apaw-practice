package es.upm.miw.apaw_practice.adapters.rest.ticket_bus;

import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.daos.BusRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticket_bus.daos.TripRepository;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.ticket_bus.Bus;
import es.upm.miw.apaw_practice.domain.models.ticket_bus.Trip;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
@RestTestConfig
public class BusResourceIT {
    @Autowired
    private WebTestClient webTestClient;
    private TripRepository tripRepository;
    private BusRepository busRepository;

    @Test
    void testCreate() {
        Bus bus = new Bus("C1", true, new Trip("Madrid-Toledo"));
        this.webTestClient
                .post()
                .uri(BusResource.BUSES)
                .body(BodyInserters.fromValue(bus))
                .exchange()
                .expectStatus().isOk();

    }

    @Test
    void testUpdateTrip() {
        Trip trip = new Trip("Toledo-Madrid", "18:00");
        String referenceBus = "C-123";
        this.webTestClient
                .put()
                .uri(BusResource.BUSES + BusResource.REFERENCE_BUS + BusResource.TRIPS_PATH,
                        referenceBus, "Madrid-Toledo")
                .exchange()
                .expectStatus().isOk();
    }
}
