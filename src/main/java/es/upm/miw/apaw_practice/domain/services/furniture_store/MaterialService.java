package es.upm.miw.apaw_practice.domain.services.furniture_store;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.furniture_store.Material;
import es.upm.miw.apaw_practice.domain.persistence_ports.furniture_store.MaterialPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {

    private final MaterialPersistence materialPersistence;

    @Autowired
    public MaterialService(MaterialPersistence materialPersistence) {
        this.materialPersistence = materialPersistence;
    }

    public Material create(Material material) {
        this.assertMaterialNameNotExist(material.getName());
        return this.materialPersistence.create(material);
    }

    public void assertMaterialNameNotExist(String name) {
        if (this.materialPersistence.existName(name)) {
            throw new ConflictException("Name exist: " + name);
        }
    }
}
