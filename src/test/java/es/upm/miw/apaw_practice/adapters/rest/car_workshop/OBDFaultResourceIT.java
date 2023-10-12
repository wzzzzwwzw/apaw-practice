package es.upm.miw.apaw_practice.adapters.rest.car_workshop;

import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.CarWorkshopSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.car_workshop.OBDFault;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RestTestConfig
public class OBDFaultResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private CarWorkshopSeederService carWorkshopSeederService;

    @AfterEach
    void resetDataBase() {
        this.carWorkshopSeederService.deleteAll();
        this.carWorkshopSeederService.seedDatabase();
    }

    @Test
    void testFindByIsITVSafe() {
        this.webTestClient
                .get()
                .uri(OBDFaultResource.OBDFAULTS + OBDFaultResource.ISNOTITVSAFE)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.OK)
                .expectBodyList(OBDFault.class)
                .value(obdFaults -> assertEquals(obdFaults.size(), 2));
    }

    @Test
    void testPartialUpdate() {
        OBDFault updatedOBDFault = new OBDFault("P0001", "Fuel Volume Regulator Control Circuit/Open", false,
                "Check the fuel cap PLEASE MY LORD");
        this.webTestClient
                .patch()
                .uri(OBDFaultResource.OBDFAULTS + OBDFaultResource.CODE, "P0001")
                .body(BodyInserters.fromValue(updatedOBDFault))
                .exchange()
                .expectStatus().isOk()
                .expectBody(OBDFault.class)
                .value(obdFault -> assertEquals(obdFault.getCode(), updatedOBDFault.getCode()))
                .value(obdFault -> assertEquals(obdFault.getIsITVSafe(), updatedOBDFault.getIsITVSafe()))
                .value(obdFault -> assertEquals(obdFault.getDescription(), updatedOBDFault.getDescription()))
                .value(obdFault -> assertEquals(obdFault.getSolution(), updatedOBDFault.getSolution()));
    }

    @Test
    void testPartialUpdateNonExistingNewCode() {
        OBDFault updatedOBDFault = new OBDFault("P0666", "Fuel Volume Regulator Control Circuit/Open", false,
                "Check the fuel cap PLEASE MY LORD");
        this.webTestClient
                .patch()
                .uri(OBDFaultResource.OBDFAULTS + OBDFaultResource.CODE, "P0001")
                .body(BodyInserters.fromValue(updatedOBDFault))
                .exchange()
                .expectStatus().isOk()
                .expectBody(OBDFault.class)
                .value(obdFault -> assertEquals(obdFault.getCode(), updatedOBDFault.getCode()))
                .value(obdFault -> assertEquals(obdFault.getIsITVSafe(), updatedOBDFault.getIsITVSafe()))
                .value(obdFault -> assertEquals(obdFault.getDescription(), updatedOBDFault.getDescription()));
    }

    @Test
    void testPartialUpdateNonExistingCode() {
        OBDFault updatedOBDFault = new OBDFault("P0666", "Fuel Volume Regulator Control Circuit/Open", false,
                "Check the fuel cap PLEASE MY LORD");
        this.webTestClient
                .patch()
                .uri(OBDFaultResource.OBDFAULTS + OBDFaultResource.CODE, "iDontExist")
                .body(BodyInserters.fromValue(updatedOBDFault))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void testPartialUpdateExistingNewCode() {
        OBDFault updatedOBDFault = new OBDFault("P0300", "Fuel Volume Regulator Control Circuit/Open", false,
                "Check the fuel cap PLEASE MY LORD");
        this.webTestClient
                .patch()
                .uri(OBDFaultResource.OBDFAULTS + OBDFaultResource.CODE, "P0002")
                .body(BodyInserters.fromValue(updatedOBDFault))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }
}
