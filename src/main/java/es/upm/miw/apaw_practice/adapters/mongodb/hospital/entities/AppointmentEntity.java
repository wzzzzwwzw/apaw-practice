package es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities;

import es.upm.miw.apaw_practice.domain.models.hospital.Appointment;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Document
public class AppointmentEntity {
    @Id
    private String id;
    private LocalDateTime appointmentHour;
    private Boolean urgent;
    private String appointmentRoom;

    public AppointmentEntity() {
        //empty for framework
    }

    public AppointmentEntity(LocalDateTime appointmentHour, Boolean urgent, String appointmentRoom) {
        this.id = UUID.randomUUID().toString();
        this.appointmentHour = appointmentHour;
        this.urgent = urgent;
        this.appointmentRoom = appointmentRoom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getAppointmentHour() {
        return appointmentHour;
    }

    public void setAppointmentHour(LocalDateTime appointmentHour) {
        this.appointmentHour = appointmentHour;
    }

    public Boolean getUrgent() {
        return urgent;
    }

    public void setUrgent(Boolean urgent) {
        this.urgent = urgent;
    }

    public String getAppointmentRoom() {
        return appointmentRoom;
    }

    public void setAppointmentRoom(String appointmentRoom) {
        this.appointmentRoom = appointmentRoom;
    }

    public Appointment toAppointment() {
        Appointment appointment = new Appointment();
        BeanUtils.copyProperties(this, appointment);
        return appointment;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentEntity that = (AppointmentEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(appointmentHour, that.appointmentHour) && Objects.equals(urgent, that.urgent) && Objects.equals(appointmentRoom, that.appointmentRoom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, appointmentHour, urgent, appointmentRoom);
    }

    @Override
    public String toString() {
        return "AppointmentEntity{" +
                "id='" + id + '\'' +
                ", appointmentHour=" + appointmentHour +
                ", urgent=" + urgent +
                ", appointmentRoom='" + appointmentRoom + '\'' +
                '}';
    }
}
