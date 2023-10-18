package es.upm.miw.apaw_practice.domain.models.ticket_bus;

public interface TripBuilder {

    interface Path {
        Departure path(String path);
    }

    interface Departure {
        Arrive departure(String departure);
    }

    interface Arrive {
        RegistrationDate arrive(String arrive);
    }

    interface RegistrationDate {
        Optionals numStops(String registrationDate);
    }


    interface Optionals {
        Trip build();
    }
}
