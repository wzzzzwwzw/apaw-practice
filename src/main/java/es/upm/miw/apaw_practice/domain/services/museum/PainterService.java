package es.upm.miw.apaw_practice.domain.services.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Painter;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.PainterPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PainterService {

    private final PainterPersistence painterPersistence;

    @Autowired
    public PainterService(PainterPersistence painterPersistence) {
        this.painterPersistence = painterPersistence;
    }

    public Painter update(String surname, Painter painter) {
        // TODO
        return null;
    }
}
