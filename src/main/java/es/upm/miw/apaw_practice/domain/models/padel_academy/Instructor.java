package es.upm.miw.apaw_practice.domain.models.padel_academy;


public class Instructor {
    private String dni;
    private String name;
    private Integer phoneNumber;

    public Instructor() {
        //empty for framework
    }

    public Instructor(String dni, String name, Integer phoneNumber) {
        this.dni = dni;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
