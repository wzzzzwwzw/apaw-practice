package es.upm.miw.apaw_practice.domain.services.museum;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.museum.ArtWork;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.ArtWorkPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtWorkService {

    private final ArtWorkPersistence artWorkPersistence;

    @Autowired
    public ArtWorkService(ArtWorkPersistence artWorkPersistence) {
        this.artWorkPersistence = artWorkPersistence;
    }

    public ArtWork findByInventoryNumber(String inventoryNumber) {
        return this.artWorkPersistence.findByInventoryNumber(inventoryNumber);
    }

    public ArtWork create(ArtWork artWork) {
        // TODO
        return null;
    }
}
