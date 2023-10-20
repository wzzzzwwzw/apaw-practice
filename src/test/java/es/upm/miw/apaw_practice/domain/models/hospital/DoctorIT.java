package es.upm.miw.apaw_practice.domain.models.hospital;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DoctorIT {
    @Test
    void testDoctorBuilder() {
        Doctor doctor = new Doctor.Builder()
                .medicalLicenseCode("TEST111")
                .speciality("TEST")
                .department(new Department("TEST",999,9))
                .build();
        assertNotNull(doctor);
        assertEquals("TEST111", doctor.getMedicalLicenseCode());
        assertEquals("TEST", doctor.getSpeciality());
        assertEquals(9, doctor.getDepartment().getFloor());
        assertEquals(999, doctor.getDepartment().getAvailableBeds());
    }
}
