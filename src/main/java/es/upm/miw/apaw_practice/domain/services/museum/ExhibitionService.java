package es.upm.miw.apaw_practice.domain.services.museum;

import es.upm.miw.apaw_practice.domain.persistence_ports.museum.ExhibitionPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExhibitionService {

    private final ExhibitionPersistence exhibitionPersistence;

    @Autowired
    public ExhibitionService(ExhibitionPersistence exhibitionPersistence) {
        this.exhibitionPersistence = exhibitionPersistence;
    }

    public void delete(String exhibitionName) {
        this.exhibitionPersistence.delete(exhibitionName);
    }
}
