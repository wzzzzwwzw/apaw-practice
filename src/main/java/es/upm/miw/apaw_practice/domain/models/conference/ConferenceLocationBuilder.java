package es.upm.miw.apaw_practice.domain.models.conference;

public interface ConferenceLocationBuilder {
    interface Id {
        City id(String id);
    }

    interface City {
        Building city(String city);
    }

    interface Building {
        Hall building(String building);
    }

    interface Hall {
        Build hall(String hall);
    }

    interface Build {
        ConferenceLocation build();
    }
}
