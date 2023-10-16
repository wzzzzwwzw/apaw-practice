package es.upm.miw.apaw_practice.adapters.mongodb.airport.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class AircraftRepositoryIT {
    @Autowired
    private AircraftRepository aircraftRepository;
}
