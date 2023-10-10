package es.upm.miw.apaw_practice.adapters.rest.car_workshop;

import es.upm.miw.apaw_practice.domain.models.car_workshop.OBDFault;
import es.upm.miw.apaw_practice.domain.services.car_workshop.OBDFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;


@RestController
@RequestMapping(OBDFaultResource.OBDFAULTS)
public class OBDFaultResource {

    static final String OBDFAULTS = "/car-workshop/obd-faults";

    static final String ISNOTITVSAFE = "/cannot-pass-itv";

    private final OBDFaultService obdFaultService;

    @Autowired
    public OBDFaultResource(OBDFaultService obdFaultService) {
        this.obdFaultService = obdFaultService;
    }

    @GetMapping(ISNOTITVSAFE)
    public Stream<OBDFault> findByIsNotITVSafe() {
        return this.obdFaultService.findByIsITVSafe(false);
    }
}
