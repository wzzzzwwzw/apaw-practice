package es.upm.miw.apaw_practice.adapters.rest.hospital;

import es.upm.miw.apaw_practice.domain.models.hospital.Doctor;
import es.upm.miw.apaw_practice.domain.services.hospital.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(DoctorResource.DOCTORS)
public class DoctorResource {
    static final String DOCTORS = "/hospital/doctors";
    static final String MEDICAL_LICENSE_CODE = "/{medicalLicenseCode}";
    private final DoctorService doctorService;

    @Autowired
    public DoctorResource(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping(DOCTORS)
    public Doctor read(@PathVariable String medicalLicenseCode) {
        return this.doctorService.read(medicalLicenseCode);
    }

    @PostMapping
    public Doctor create(@RequestBody Doctor doctor) {
        return this.doctorService.create(doctor);
    }

    @DeleteMapping(MEDICAL_LICENSE_CODE)
    public void delete(@PathVariable String medicalLicenseCode) {
        this.doctorService.delete(medicalLicenseCode);
    }


}
