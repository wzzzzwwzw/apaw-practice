package es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities;

import es.upm.miw.apaw_practice.domain.models.hospital.Appointment;
import es.upm.miw.apaw_practice.domain.models.hospital.Doctor;
import es.upm.miw.apaw_practice.domain.models.hospital.Patient;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class PatientEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String socialInsuranceNumber;
    private String gender;
    private LocalDate birthDate;
    private List<DoctorEntity> doctorsEntities;
    private List<AppointmentEntity> appointmentsEntities;

    public PatientEntity() {
        //empty for framework
    }

    public PatientEntity(String socialInsuranceNumber, String gender, LocalDate birthDate, List<DoctorEntity> doctorsEntities, List<AppointmentEntity> appointmentsEntities) {
        this.id = UUID.randomUUID().toString();
        this.socialInsuranceNumber = socialInsuranceNumber;
        this.gender = gender;
        this.birthDate = birthDate;
        this.doctorsEntities = doctorsEntities;
        this.appointmentsEntities = appointmentsEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<DoctorEntity> getDoctorsEntities() {
        return doctorsEntities;
    }

    public void setDoctorsEntities(List<DoctorEntity> doctorsEntities) {
        this.doctorsEntities = doctorsEntities;
    }

    public List<AppointmentEntity> getAppointmentsEntities() {
        return appointmentsEntities;
    }

    public void setAppointmentsEntities(List<AppointmentEntity> appointmentsEntities) {
        this.appointmentsEntities = appointmentsEntities;
    }

    public Patient toPatient() {
        Patient patient = new Patient();
        List<Doctor> doctors = this.doctorsEntities
                .stream()
                .map(DoctorEntity::toDoctor)
                .toList();
        List<Appointment> appointments = this.appointmentsEntities
                .stream()
                .map(AppointmentEntity::toAppointment)
                .toList();
        BeanUtils.copyProperties(this, patient);
        patient.setDoctors(doctors);
        patient.setAppointments(appointments);
        return patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientEntity that = (PatientEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(socialInsuranceNumber, that.socialInsuranceNumber) && Objects.equals(gender, that.gender) && Objects.equals(birthDate, that.birthDate) && Objects.equals(doctorsEntities, that.doctorsEntities) && Objects.equals(appointmentsEntities, that.appointmentsEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, socialInsuranceNumber, gender, birthDate, doctorsEntities, appointmentsEntities);
    }

    @Override
    public String toString() {
        return "PatientEntity{" +
                "id='" + id + '\'' +
                ", socialInsuranceNumber='" + socialInsuranceNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                ", doctorsEntities=" + doctorsEntities +
                ", appointmentsEntities=" + appointmentsEntities +
                '}';
    }
}
