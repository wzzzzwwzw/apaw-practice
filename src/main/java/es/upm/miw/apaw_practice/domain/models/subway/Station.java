package es.upm.miw.apaw_practice.domain.models.subway;

public class Station {
    private String name;
    private String order;
    private Boolean open;

    public Station(String name, String order, Boolean open) {
        this.name = name;
        this.order = order;
        this.open = open;
    }

    public Station() {
        //for framework
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Boolean isOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", order='" + order + '\'' +
                ", open=" + open +
                '}';
    }
}
