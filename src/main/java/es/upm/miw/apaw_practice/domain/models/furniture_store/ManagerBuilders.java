package es.upm.miw.apaw_practice.domain.models.furniture_store;

public interface ManagerBuilders {

    interface AffiliationNumber {
        Name affiliationNumber(String affiliationNumber);
    }

    interface Name {
        Optionals name(String name);
    }

    interface Optionals {
        Optionals promotionCandidate(Boolean promotionCandidate);
        Manager build();
    }
}
