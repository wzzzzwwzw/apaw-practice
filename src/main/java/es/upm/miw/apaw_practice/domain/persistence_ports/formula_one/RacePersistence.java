package es.upm.miw.apaw_practice.domain.persistence_ports.formula_one;

import es.upm.miw.apaw_practice.domain.models.formula_one.Race;

public interface RacePersistence {
    Race findByCircuitName(String circuitName);
}
