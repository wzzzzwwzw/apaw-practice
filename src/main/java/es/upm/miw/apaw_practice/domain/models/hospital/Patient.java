package es.upm.miw.apaw_practice.domain.models.hospital;

import java.time.LocalDate;
import java.util.List;

public class Patient {

    private String socialInsuranceNumber;
    private String allergicMedicine;
    private LocalDate birthDate;
    private List<Doctor> doctors;
    private List<Appointment> appointments;

    public Patient() {
        //empty for framework
    }

    public Patient(String socialInsuranceNumber, String allergicMedicine, LocalDate birthDate, List<Doctor> doctors, List<Appointment> appointments) {
        this.socialInsuranceNumber = socialInsuranceNumber;
        this.allergicMedicine = allergicMedicine;
        this.birthDate = birthDate;
        this.doctors = doctors;
        this.appointments = appointments;
    }

    public String getSocialInsuranceNumber() {
        return socialInsuranceNumber;
    }

    public void setSocialInsuranceNumber(String socialInsuranceNumber) {
        this.socialInsuranceNumber = socialInsuranceNumber;
    }

    public String getAllergicMedicine() {
        return allergicMedicine;
    }

    public void setAllergicMedicine(String allergicMedicine) {
        this.allergicMedicine = allergicMedicine;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }


    @Override
    public String toString() {
        return "Patients{" +
                "socialInsuranceNumber=" + socialInsuranceNumber +
                ", allergicMedicine='" + allergicMedicine + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", doctors='" + doctors + '\'' +
                ", appointments='" + appointments + '\'' +
                '}';
    }

    public static interface TreeDoctors {
    }
}
