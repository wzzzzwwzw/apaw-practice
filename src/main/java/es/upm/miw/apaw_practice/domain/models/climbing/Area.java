package es.upm.miw.apaw_practice.domain.models.climbing;

import es.upm.miw.apaw_practice.domain.models.climbing.composite.TreeAreas;

import java.util.List;

public class Area implements TreeAreas {
    private String name;
    private String location;
    private boolean easyAccess;
    private List<Route> routes;
    private Expedition expedition;

    public Area() {
        //empty for framework
    }

    public Area(String name, String location, boolean easyAccess, List<Route> routes, Expedition expedition) {
        this.name = name;
        this.location = location;
        this.easyAccess = easyAccess;
        this.routes = routes;
        this.expedition = expedition;
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

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public void addRoute(Route route) {
        this.routes.add(route);
    }

    public Expedition getExpedition() {
        return expedition;
    }

    public void setExpedition(Expedition expedition) {
        this.expedition = expedition;
    }

    @Override
    public String toString() {
        return "Area{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", easyAccess=" + easyAccess +
                ", routes=" + routes +
                ", expedition=" + expedition +
                '}';
    }

    @Override
    public Boolean isComposite() {
        return false;
    }

    @Override
    public void add(TreeAreas treeAreas) {
        throw new UnsupportedOperationException("Unsupported operation in Area leaf");
    }

    @Override
    public void remove(TreeAreas treeAreas) {
        // Do nothing because is a leaf
    }
}
