package es.upm.miw.apaw_practice.domain.services.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Painter;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.PainterPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class PainterService {

    private final PainterPersistence painterPersistence;

    @Autowired
    public PainterService(PainterPersistence painterPersistence) {
        this.painterPersistence = painterPersistence;
    }

    public Stream<Painter> findByArtWorkInRoomFloorGreaterThan(Integer roomFloor) {
        return this.painterPersistence.findAll()
                .filter(painter -> painter.getArtWorks().stream()
                        .anyMatch(artWork -> artWork.getRoom().getFloor() > roomFloor));
    }

    public Painter update(String surname, Painter painter) {
        Painter persisted = this.painterPersistence.findBySurname(surname);
        persisted.setName(painter.getName());
        persisted.setBirthDate(painter.getBirthDate());
        persisted.setDeathDate(painter.getDeathDate());
        persisted.setArtWorks(painter.getArtWorks());
        return this.painterPersistence.update(painter);
    }
}
