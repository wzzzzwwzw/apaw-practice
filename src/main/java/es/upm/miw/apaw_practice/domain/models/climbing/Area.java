package es.upm.miw.apaw_practice.domain.models.climbing;

import es.upm.miw.apaw_practice.domain.models.computer_store.Monitor;
import es.upm.miw.apaw_practice.domain.models.music.Artist;
import es.upm.miw.apaw_practice.domain.models.music.Genre;

import java.util.ArrayList;
import java.util.List;

public class Area {
    private String areaName;
    private String location;
    private boolean easyAccess;
    private List<Route> routes;
    private Expedition expedition;

    public Area() {
        this.routes = new ArrayList<>();
    }

    public Area(String areaName, String location, boolean easyAccess, Expedition expedition) {
        this.areaName = areaName;
        this.location = location;
        this.easyAccess = easyAccess;
        this.expedition = expedition;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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

    public List<Route> getRoutes() {
        return this.routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public void addRoute(Route route) {
        this.routes.add(route);
    }

    public Expedition getExpedition() {
        return  this.expedition;
    }

    public void setExpedition(Expedition expedition) {
        this.expedition = expedition;
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaName='" + areaName + '\'' +
                ", location='" + location + '\'' +
                ", easyAccess=" + easyAccess +
                '}';
    }
}
