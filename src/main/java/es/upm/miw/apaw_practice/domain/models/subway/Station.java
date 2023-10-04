package es.upm.miw.apaw_practice.domain.models.subway;

public class Station {
    private String name;
    private String order;
    private boolean open;

    public Station(String name, String order, boolean open) {
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

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
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
