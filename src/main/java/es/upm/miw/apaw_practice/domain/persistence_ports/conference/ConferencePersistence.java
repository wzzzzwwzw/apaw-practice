package es.upm.miw.apaw_practice.domain.persistence_ports.conference;

import es.upm.miw.apaw_practice.domain.models.conference.Conference;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ConferencePersistence {
    void delete(String id);

    Stream<Conference> readAll();
}
