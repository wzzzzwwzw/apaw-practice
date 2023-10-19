package es.upm.miw.apaw_practice.domain.persistence_ports.hospital;

import es.upm.miw.apaw_practice.domain.models.hospital.Patient;

public interface PatientPersistence {
    Patient read(String socialInsuranceNumber);

    Patient updateAllergicMedicine(String socialInsuranceNumber, String newAllergicMedicine);

    Integer findTotalOccupiedBedsByAppointmentRoom(String AppointmentRoom, Boolean urgent);
}
