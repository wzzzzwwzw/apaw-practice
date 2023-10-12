package es.upm.miw.apaw_practice.adapters.mongodb.climbing.entities;

import es.upm.miw.apaw_practice.domain.models.climbing.Area;
import es.upm.miw.apaw_practice.domain.models.climbing.Route;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class AreaEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String location;
    private boolean easyAccess;
    private List<RouteEntity> routeEntities;
    @DBRef
    private ExpeditionEntity expeditionEntity;

    public AreaEntity() {

    }

    public AreaEntity(String name, String location, boolean easyAccess, List<RouteEntity> routeEntities, ExpeditionEntity expeditionEntity) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.location = location;
        this.easyAccess = easyAccess;
        this.routeEntities = routeEntities;
        this.expeditionEntity = expeditionEntity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean getEasyAccess() {
        return easyAccess;
    }

    public void setEasyAccess(boolean easyAccess) {
        this.easyAccess = easyAccess;
    }

    public List<RouteEntity> getRouteEntities() {
        return routeEntities;
    }

    public void setRouteEntities(List<RouteEntity> routeEntities) {
        this.routeEntities = routeEntities;
    }

    public ExpeditionEntity getExpeditionEntity() {
        return expeditionEntity;
    }

    public void setExpeditionEntity(ExpeditionEntity expeditionEntity) {
        this.expeditionEntity = expeditionEntity;
    }

    public Area toArea() {
        List<Route> routes = this.routeEntities.stream()
                .map(RouteEntity::toRoute)
                .toList();
        return new Area(name, location, easyAccess, routes, expeditionEntity.toExpedition());
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (name.equals(((AreaEntity) obj).name));
    }

    @Override
    public String toString() {
        return "AreaEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", easyAccess=" + easyAccess +
                ", routeEntities=" + routeEntities +
                ", expeditionEntity=" + expeditionEntity +
                '}';
    }
}
