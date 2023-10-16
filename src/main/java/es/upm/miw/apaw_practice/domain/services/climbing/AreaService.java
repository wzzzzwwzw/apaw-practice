package es.upm.miw.apaw_practice.domain.services.climbing;

import es.upm.miw.apaw_practice.domain.models.climbing.Area;
import es.upm.miw.apaw_practice.domain.models.climbing.Route;
import es.upm.miw.apaw_practice.domain.persistence_ports.climbing.AreaPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaService {

    private final AreaPersistence areaPersistence;

    @Autowired
    public AreaService(AreaPersistence areaPersistence) {
        this.areaPersistence = areaPersistence;
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


}
