package es.upm.miw.apaw_practice.domain.models.food_delivery;

public class Restaurant {

    private String name;
    private String type;
    private String description;
    private String adress;
    private Integer maximumOrders;

    public Restaurant(){}

    public Restaurant(String name, String type, String description, String adress, Integer maximumOrders) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.adress = adress;
        this.maximumOrders = maximumOrders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getMaximumOrders() {
        return maximumOrders;
    }

    public void setMaximumOrders(Integer maximumOrders) {
        this.maximumOrders = maximumOrders;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", adress='" + adress + '\'' +
                ", maximumOrders=" + maximumOrders +
                '}';
    }
}
