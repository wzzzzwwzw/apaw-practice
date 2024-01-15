package es.upm.miw.apaw_practice.domain.models.padel_academy;


import es.upm.miw.apaw_practice.domain.models.padel_academy.builder.InstructorBuilder;

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

    public static InstructorBuilder.Dni builder() {return new Builder();}

    public static class Builder implements InstructorBuilder.Dni, InstructorBuilder.Name, InstructorBuilder.PhoneNumber, InstructorBuilder.Build {
        private final Instructor instructor;

        public Builder() {this.instructor = new Instructor();}

        @Override
        public InstructorBuilder.Name dni(String dni) {
            this.instructor.dni = dni;
            return this;
        }

        @Override
        public InstructorBuilder.PhoneNumber name(String name) {
            this.instructor.name = name;
            return this;
        }

        @Override
        public InstructorBuilder.Build phoneNumber(Integer phoneNumber) {
            this.instructor.phoneNumber = phoneNumber;
            return this;
        }

        @Override
        public Instructor build() {
            return this.instructor;
        }
    }
}
