package es.upm.miw.apaw_practice.domain.persistence_ports.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Exhibition;

import java.util.stream.Stream;

public interface ExhibitionPersistence {
    Stream<Exhibition> findAll();

    void delete(String exhibitionName);
}
