package es.upm.miw.apaw_practice.domain.models.padel_academy.builder;

import es.upm.miw.apaw_practice.domain.models.padel_academy.Instructor;

public interface InstructorBuilder {
    public interface Dni {
        Name dni(String dni);
    }

    public interface Name {
        PhoneNumber name(String name);
    }

    public interface PhoneNumber {
        Build phoneNumber(Integer phoneNumber);
    }

    public interface Build {
        Instructor build();
    }
}
