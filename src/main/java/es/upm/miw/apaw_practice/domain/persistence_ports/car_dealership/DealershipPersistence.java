package es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership;

import es.upm.miw.apaw_practice.domain.models.car_dealership.Dealership;

import java.util.stream.Stream;

public interface DealershipPersistence {

    void delete(String id);

    Stream<Dealership> readAll();
}
