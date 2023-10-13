package es.upm.miw.apaw_practice.domain.persistence_ports.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Painter;

import java.util.stream.Stream;

public interface PainterPersistence {
    Stream<Painter> findAll();

    Painter findBySurname(String surname);

    Painter update(Painter painter);
}
