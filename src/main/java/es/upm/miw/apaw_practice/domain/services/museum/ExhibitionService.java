package es.upm.miw.apaw_practice.domain.services.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Exhibition;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.ExhibitionPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.PainterPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ExhibitionService {

    private final ExhibitionPersistence exhibitionPersistence;
    private final PainterPersistence painterPersistence;

    @Autowired
    public ExhibitionService(ExhibitionPersistence exhibitionPersistence,
                             PainterPersistence painterPersistence) {
        this.exhibitionPersistence = exhibitionPersistence;
        this.painterPersistence = painterPersistence;
    }

    public Stream<Exhibition> findByArtWorkExhibitedOfPainterBySurname(String painterSurname) {
        return this.exhibitionPersistence.findAll()
                .filter(exhibition -> exhibition.getArtWorks().stream()
                        .anyMatch(artWork -> artWork.isExhibited() &&
                                this.painterPersistence.findBySurname(painterSurname).getArtWorks().stream()
                                        .anyMatch(p -> p.getInventoryNumber().equals(artWork.getInventoryNumber()))));
    }

    public void delete(String exhibitionName) {
        this.exhibitionPersistence.delete(exhibitionName);
    }
}
