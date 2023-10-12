package es.upm.miw.apaw_practice.domain.persistence_ports.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Painter;

public interface PainterPersistence {
    Painter findBySurname(String surname);

    Painter update(Painter painter);
}
