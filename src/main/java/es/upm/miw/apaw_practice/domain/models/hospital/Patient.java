package es.upm.miw.apaw_practice.domain.models.hospital;

import java.time.LocalDate;
import java.util.List;

public class Patient {

    private String socialInsuranceNumber;
    private String gender;
    private LocalDate birthDate;
    private List<Doctor> doctors;
    private List<Appointment> appointments;

    public Patient() {
        //empty for framework
    }

    public Patient(String socialInsuranceNumber, String gender, LocalDate birthDate, List<Doctor> doctors, List<Appointment> appointments) {
        this.socialInsuranceNumber = socialInsuranceNumber;
        this.gender = gender;
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
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
                ", gender='" + gender + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", doctors='" + doctors + '\'' +
                ", appointments='" + appointments + '\'' +
                '}';
    }
}
