package es.upm.miw.apaw_practice.adapters.mongodb.hospital;

import es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos.DepartmentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos.DoctorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos.PatientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.DepartmentEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.AppointmentEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.DoctorEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.PatientEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class HospitalSeederService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Hospital Initial Load -----------");
        DepartmentEntity[] departments = {
                new DepartmentEntity("Emergency", 10 , 0),
                new DepartmentEntity("Pediatrics", 7 , 1),
                new DepartmentEntity("Dermatology", 5, 2),
                new DepartmentEntity("Rehabilitation", 15 , 1),
                new DepartmentEntity("Surgery", 8, 2),
                new DepartmentEntity("Radiology", 0, 3)
        };
        this.departmentRepository.saveAll(Arrays.asList(departments));

        DoctorEntity[] doctors = {
                new DoctorEntity("M001","E01", departments[0]),
                new DoctorEntity("M002","D02", departments[2]),
                new DoctorEntity("M003","P01", departments[1]),
                new DoctorEntity("M004","R01", departments[3]),
                new DoctorEntity("M005","D01", departments[4]),
                new DoctorEntity("M999","R99", departments[5])
        };
        this.doctorRepository.saveAll(Arrays.asList(doctors));

        AppointmentEntity[] appointments = {
                 new AppointmentEntity(LocalDateTime.of(2023,5,11,10,30), Boolean.TRUE, "123"),
                new AppointmentEntity(LocalDateTime.of(2023,7,22,12,10), Boolean.FALSE, "101"),
                new AppointmentEntity(LocalDateTime.of(2023,4,11,11,11), Boolean.FALSE, "001"),
                new AppointmentEntity(LocalDateTime.of(2023,6,22,8,30), Boolean.FALSE, "120"),
                new AppointmentEntity(LocalDateTime.of(2023,11,11,10,30), Boolean.TRUE, "203"),
                new AppointmentEntity(LocalDateTime.of(2023,2,1,9,20), Boolean.FALSE, "005"),
                new AppointmentEntity(LocalDateTime.of(2023,1,1,1,1), Boolean.FALSE, "005")
        };

        PatientEntity[] patients = {
                new PatientEntity("000000000", "NONE", LocalDate.of(1999,1,1),  Arrays.asList(doctors[0], doctors[2]), Arrays.asList(appointments[0], appointments[1])),
                new PatientEntity("111111111", "NONE", LocalDate.of(2000,2,2), Collections.singletonList(doctors[0]), List.of(appointments[2])),
                new PatientEntity("222222222", "NONE", LocalDate.of(1967,11,21), Collections.singletonList(doctors[1]), List.of(appointments[3])),
                new PatientEntity("333333333", "NONE", LocalDate.of(1987,5,11), Arrays.asList(doctors[4], doctors[3]), Arrays.asList(appointments[4], appointments[5],appointments[6]))
        };
        this.patientRepository.saveAll(Arrays.asList(patients));
    }

    public void deleteAll() {
        this.departmentRepository.deleteAll();
        this.doctorRepository.deleteAll();
        this.patientRepository.deleteAll();
    }
}
