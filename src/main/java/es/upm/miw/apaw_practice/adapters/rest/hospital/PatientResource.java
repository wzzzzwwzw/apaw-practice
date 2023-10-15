package es.upm.miw.apaw_practice.adapters.rest.hospital;

import es.upm.miw.apaw_practice.domain.models.hospital.Patient;
import es.upm.miw.apaw_practice.domain.services.hospital.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PatientResource.PATIENTS)
public class PatientResource {
    static final String PATIENTS = "/hospital/patients";
    static final String SOCIAL_INSURANCE_NUMBER = "/{socialInsuranceNumber}";
    private final PatientService patientService;

    @Autowired
    public PatientResource(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(SOCIAL_INSURANCE_NUMBER)
    public Patient read(@PathVariable String socialInsuranceNumber) {
        return this.patientService.read(socialInsuranceNumber);
    }

}
