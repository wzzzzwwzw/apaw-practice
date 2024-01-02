package es.upm.miw.apaw_practice.domain.services.furniture_store;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.furniture_store.Furniture;
import es.upm.miw.apaw_practice.domain.models.furniture_store.Material;
import es.upm.miw.apaw_practice.domain.persistence_ports.furniture_store.FurnitureStorePersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.furniture_store.MaterialPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    private final MaterialPersistence materialPersistence;
    private final FurnitureStorePersistence furnitureStorePersistence;

    @Autowired
    public MaterialService(MaterialPersistence materialPersistence, FurnitureStorePersistence furnitureStorePersistence) {
        this.materialPersistence = materialPersistence;
        this.furnitureStorePersistence = furnitureStorePersistence;
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

    public List<String> findUniqueMaterialTypeByManagerPromotionCandidate(Boolean promotionCandidate) {
        List<Furniture> furnitureList = this.furnitureStorePersistence.findFurnituresByManagerPromotionCandidate(promotionCandidate);

        if (furnitureList.isEmpty()) {
            throw new NotFoundException("No furniture found with " + promotionCandidate + " promotion candidate");
        }

        return furnitureList
                .stream()
                .map(Furniture::getMaterials)
                .flatMap(List::stream)
                .map(Material::getType)
                .distinct()
                .toList();
    }

}
