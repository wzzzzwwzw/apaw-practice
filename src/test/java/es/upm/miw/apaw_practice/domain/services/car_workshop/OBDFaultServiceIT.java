package es.upm.miw.apaw_practice.domain.services.car_workshop;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.CarWorkshopSeederService;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.car_workshop.OBDFault;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class OBDFaultServiceIT {

    @Autowired
    private OBDFaultService obdFaultService;

    @Autowired
    private CarWorkshopSeederService carWorkshopSeederService;

    @AfterEach
    void resetDataBase() {
        this.carWorkshopSeederService.deleteAll();
        this.carWorkshopSeederService.seedDatabase();
    }

    @Test
    void testFindByIsITVSafe() {
        Stream<OBDFault> result = this.obdFaultService.findByIsITVSafe(false);
        assertEquals(result.toList().size(), 2);
    }

    @Test
    void testPartialUpdate() {
        String codeToUpdate = "P0001";
        OBDFault obdFaultToUpdate = new OBDFault("P0666", "Fuel Volume Regulator Control", false,
                "Check the fuel cap, this is a common problem.");
        OBDFault updatedOBDFault = this.obdFaultService.updatePartial(codeToUpdate, obdFaultToUpdate);
        assertEquals(updatedOBDFault.getCode(), obdFaultToUpdate.getCode());
        assertEquals(updatedOBDFault.getDescription(), obdFaultToUpdate.getDescription());
    }

    @Test
    void testPartialUpdateNotExisting() {
        String code = "nope";
        OBDFault obdFaultToUpdate = new OBDFault("P0001", "Fuel Volume Regulator Control", false,
                "Check the fuel cap, this is a common problem.");
        assertThrows(NotFoundException.class, () -> this.obdFaultService.updatePartial(code, obdFaultToUpdate));
    }

    @Test
    void testPartialUpdateExisting() {
        String code = "P0001";
        OBDFault obdFaultToUpdate = new OBDFault("P0002", "Fuel Volume Regulator Control", false,
                "Check the fuel cap, this is a common problem.");
        assertThrows(ConflictException.class, () -> this.obdFaultService.updatePartial(code, obdFaultToUpdate));
    }

    @Test
    void testFindByCarComponentName() {
        List<String> result = this.obdFaultService.findByCarComponentName("Universal Belt").toList();
        List<String> expectedList = List.of("P0001", "P0002");
        assertEquals(expectedList, result);

        List<String> resultNotExists = this.obdFaultService.findByCarComponentName("HAHAHA I DONT EXISTS").toList();
        assertEquals(resultNotExists.size() , 0);
    }
}
