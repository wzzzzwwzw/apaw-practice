package es.upm.miw.apaw_practice.adapters.mongodb.museum.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.ArtWorkRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.museum.ArtWork;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.ArtWorkPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("artWorkPersistence")
public class ArtWorkPersistenceMongodb implements ArtWorkPersistence {

    private final ArtWorkRepository artWorkRepository;

    @Autowired
    public ArtWorkPersistenceMongodb(ArtWorkRepository artWorkRepository) {
        this.artWorkRepository = artWorkRepository;
    }

    @Override
    public ArtWork create(ArtWork artWork) {
        // TODO
        return null;
    }

    @Override
    public ArtWork findByInventoryNumber(String inventoryNumber) {
        return this.artWorkRepository.findAll().stream()
                .filter(artWork -> inventoryNumber.equals(artWork.getInventoryNumber()))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Art work with inventory number: " + inventoryNumber))
                .toArtWork();
    }

    @Override
    public boolean existsInventoryNumber(String inventoryNumber) {
        // TODO
        return false;
    }
}
