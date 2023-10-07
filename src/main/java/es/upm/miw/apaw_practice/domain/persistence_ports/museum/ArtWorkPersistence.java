package es.upm.miw.apaw_practice.domain.persistence_ports.museum;

import es.upm.miw.apaw_practice.domain.models.museum.ArtWork;

public interface ArtWorkPersistence {
    ArtWork findByInventoryNumber(String inventoryNumber);
}
