package es.upm.miw.apaw_practice.adapters.mongodb.climbing.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.climbing.daos.AreaRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.climbing.entities.AreaEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.climbing.entities.RouteEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.climbing.Area;
import es.upm.miw.apaw_practice.domain.persistence_ports.climbing.AreaPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("areaPersistence")
public class AreaPersistenceMongodb implements AreaPersistence {
    private final AreaRepository areaRepository;

    @Autowired
    public AreaPersistenceMongodb(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Override
    public Area readByName(String name) {
        return this.areaRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Area name: " + name))
                .toArea();
    }

    @Override
    public Area update(Area area) {
        AreaEntity areaEntityEntity = this.areaRepository
                .findByName(area.getName())
                .orElseThrow(() -> new NotFoundException("Area name:" + area.getName()));
        List<RouteEntity> areaEntities = area.getRoutes().stream()
                .map(route -> new RouteEntity(
                        route.getName(),
                        route.getDifficulty()
                )).toList();
        areaEntityEntity.setRouteEntities(areaEntities);
        return this.areaRepository
                .save(areaEntityEntity)
                .toArea();
    }

    @Override
    public List<Area> findAll() {
        return this.areaRepository.findAll()
                .stream()
                .map(AreaEntity::toArea)
                .toList();
    }
}
