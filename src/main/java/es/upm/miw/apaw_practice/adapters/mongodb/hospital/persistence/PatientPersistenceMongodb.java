package es.upm.miw.apaw_practice.adapters.mongodb.hospital.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos.PatientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.DepartmentEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.DoctorEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.PatientEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.hospital.Patient;
import es.upm.miw.apaw_practice.domain.persistence_ports.hospital.PatientPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("patientPersistence")
public class PatientPersistenceMongodb implements PatientPersistence {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientPersistenceMongodb(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient read(String socialInsuranceNumber) {
        return this.patientRepository
                .findBySocialInsuranceNumber(socialInsuranceNumber)
                .orElseThrow(() -> new NotFoundException("Patient socialInsuranceNumber: " + socialInsuranceNumber))
                .toPatient();
    }

    @Override
    public Patient updateAllergicMedicine(String socialInsuranceNumber, String newAllergicMedicine) {
        PatientEntity patientEntity = this.patientRepository
                .findBySocialInsuranceNumber(socialInsuranceNumber)
                .orElseThrow(() -> new NotFoundException("Patient socialInsuranceNumber: " + socialInsuranceNumber));
        patientEntity.setAllergicMedicine(newAllergicMedicine);
        return this.patientRepository.save(patientEntity).toPatient();
    }

    @Override
    public Integer findTotalOccupiedBedsByAppointmentRoom(String AppointmentRoom, Boolean urgent) {
        return this.patientRepository.findAll().stream()
                .filter(patient -> patient.getAppointmentsEntities().stream()
                        .anyMatch(appointment -> appointment.getUrgent().equals(urgent) && appointment.getAppointmentRoom().equals(AppointmentRoom)))
                .flatMap(patient -> patient.getDoctorsEntities().stream())
                .map(DoctorEntity::getDepartmentEntity)
                .map(DepartmentEntity::getAvailableBeds)
                .mapToInt(Integer::intValue)
                .sum();
    }

    @Override
    public Integer findTotalAppointmentBySpeciality(String speciality) {
        return this.patientRepository.findAll().stream()
                .filter(patient -> patient.getDoctorsEntities().stream()
                        .anyMatch(doctor -> doctor.getSpeciality().equals(speciality)))
                .flatMap(patient -> patient.getAppointmentsEntities().stream())
                .filter(appointmentEntity -> appointmentEntity.getUrgent().equals(true))
                .mapToInt(appointmentEntity -> 1)
                .sum();
    }

}
