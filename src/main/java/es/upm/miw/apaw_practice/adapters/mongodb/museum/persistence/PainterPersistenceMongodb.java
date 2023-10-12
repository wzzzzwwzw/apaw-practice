package es.upm.miw.apaw_practice.adapters.mongodb.museum.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.PainterRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtWorkEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.PainterEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.museum.Painter;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.PainterPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("painterPersistence")
public class PainterPersistenceMongodb implements PainterPersistence {

    private final PainterRepository painterRepository;

    @Autowired
    public PainterPersistenceMongodb(PainterRepository painterRepository) {
        this.painterRepository = painterRepository;
    }

    @Override
    public Painter findBySurname(String surname) {
        return this.painterRepository.findAll().stream()
                .filter(painter -> surname.equals(painter.getSurname()))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Painter with surname: " + surname))
                .toPainter();
    }

    @Override
    public Painter update(Painter painter) {
        PainterEntity painterDB = this.painterRepository.findById(painter.getSurname())
                .orElseThrow(() -> new NotFoundException("Painter with surname: " + painter.getSurname()));
        painterDB.setName(painter.getName());
        painterDB.setBirthDate(painter.getBirthDate());
        painterDB.setDeathDate(painter.getDeathDate());
        painterDB.setArtWorks(painter.getArtWorks().stream()
                .map(ArtWorkEntity::new)
                .toList());
        return this.painterRepository.save(painterDB).toPainter();
    }
}
