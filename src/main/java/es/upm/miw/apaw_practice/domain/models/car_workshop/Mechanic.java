package es.upm.miw.apaw_practice.domain.models.car_workshop;

public class Mechanic {
    private String name;
    private String speciality;

    public Mechanic() {
        // empty for framework
    }

    public Mechanic(String name, String speciality) {
        this.name = name;
        this.speciality = speciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
