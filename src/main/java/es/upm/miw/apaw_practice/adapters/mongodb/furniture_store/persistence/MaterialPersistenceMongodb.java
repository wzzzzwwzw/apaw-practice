package es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.daos.MaterialRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.furniture_store.entities.MaterialEntity;
import es.upm.miw.apaw_practice.domain.models.furniture_store.Material;
import es.upm.miw.apaw_practice.domain.persistence_ports.furniture_store.MaterialPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("materialPersistence")
public class MaterialPersistenceMongodb implements MaterialPersistence {

    private final MaterialRepository materialRepository;

    @Autowired
    public MaterialPersistenceMongodb(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public Material create(Material material) {
        return this.materialRepository
                .save(new MaterialEntity(material))
                .toMaterial();
    }

    @Override
    public boolean existName(String name) {
        return this.materialRepository
                .findByName(name)
                .isPresent();
    }

}
