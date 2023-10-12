package es.upm.miw.apaw_practice.domain.models.hospital;

import java.time.LocalDateTime;

public class Appointment {

    private LocalDateTime appointmentHour;
    private Boolean urgent;
    private String appointmentRoom;

    public Appointment() {
        //empty for framework
    }

    public Appointment(LocalDateTime appointmentHour, Boolean urgent, String appointmentRoom) {
        this.appointmentHour = appointmentHour;
        this.urgent = urgent;
        this.appointmentRoom = appointmentRoom;
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



    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentHour=" + appointmentHour +
                ", appointmentRoom='" + appointmentRoom + '\'' +
                ", urgent='" + urgent + '\'' +
                '}';
    }
}
