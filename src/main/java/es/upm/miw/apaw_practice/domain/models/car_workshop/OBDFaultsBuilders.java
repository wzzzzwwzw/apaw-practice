package es.upm.miw.apaw_practice.domain.models.car_workshop;

public interface OBDFaultsBuilders {
    interface Code {
        Optionals code(String code);
    }

    interface Optionals {

        Optionals description(String description);

        Optionals isITVSafe(Boolean isITVSafe);

        Optionals solution(String solution);

        OBDFault build();
    }

}
