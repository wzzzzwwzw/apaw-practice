package es.upm.miw.apaw_practice.domain.services.climbing;

import es.upm.miw.apaw_practice.domain.models.climbing.Area;
import es.upm.miw.apaw_practice.domain.models.climbing.Climber;
import es.upm.miw.apaw_practice.domain.models.climbing.Expedition;
import es.upm.miw.apaw_practice.domain.models.climbing.Route;
import es.upm.miw.apaw_practice.domain.persistence_ports.climbing.AreaPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.climbing.ClimberPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaService {

    private final AreaPersistence areaPersistence;
    private final ClimberPersistence climberPersistence;

    @Autowired
    public AreaService(AreaPersistence areaPersistence, ClimberPersistence climberPersistence) {
        this.areaPersistence = areaPersistence;
        this.climberPersistence = climberPersistence;
    }

    public Area read(String name) {
        return this.areaPersistence.readByName(name);
    }

    public Area updateRoute(String areaName, String routeKey, Route route) {
        Area area = this.areaPersistence.readByName(areaName);
        List<Route> routes = new ArrayList<>(area.getRoutes());

        for (int i = 0; i < routes.size(); i++) {
            if (routes.get(i).getKey().equals(routeKey)) {
                routes.set(i, route);
                break;
            }
        }

        area.setRoutes(routes);

        return this.areaPersistence.update(area);
    }


    public String[] findRouteNamesByClimberLevel(String level) {
        List<Climber> climbers = this.climberPersistence.findByLevel(level);
        List<Expedition> expeditions = new ArrayList<>();
        for (Climber climber : climbers) {
            expeditions.addAll(climber.getExpeditions());
        }
        List<Area> areas = new ArrayList<>();
        for (Expedition expedition : expeditions) {
            areas.add(this.areaPersistence.findByExpeditionIdentifier(expedition.getIdentifier()));
        }
        List<Route> routes = new ArrayList<>();
        for (Area area : areas) {
            routes.addAll(area.getRoutes());
        }

        return routes.stream()
                .map(Route::getName)
                .distinct()
                .toArray(String[]::new);
    }

}
