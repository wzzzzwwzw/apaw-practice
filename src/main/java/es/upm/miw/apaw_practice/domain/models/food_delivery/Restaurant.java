package es.upm.miw.apaw_practice.domain.models.food_delivery;

import org.apache.commons.lang3.builder.Builder;

public class Restaurant implements TreeRestaurants {

    private String name;
    private String type;
    private String description;
    private String adress;
    private Integer maximumOrders;

    public Restaurant() {
    }

    public Restaurant(String name, String type, String description, String adress, Integer maximumOrders) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.adress = adress;
        this.maximumOrders = maximumOrders;
    }


    public static RestaurantBuilders.Name builder() {
        return new Builder();
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

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public void add(TreeRestaurants treeRestaurants) {
        // Do nothing because it is a leaf
    }

    @Override
    public void remove(TreeRestaurants treeRestaurants) {
        // Do nothing because it is a leaf
    }

    public static class Builder implements RestaurantBuilders.Name, RestaurantBuilders.Type,
            RestaurantBuilders.Description, RestaurantBuilders.Adress, RestaurantBuilders.MaximumOrders,
            RestaurantBuilders.Build {

        private final Restaurant restaurant;

        public Builder() {
            this.restaurant = new Restaurant();
        }

        @Override
        public RestaurantBuilders.Type name(String name) {
            this.restaurant.name = name;
            return this;
        }

        @Override
        public RestaurantBuilders.Description type(String type) {
            this.restaurant.type = type;
            return this;
        }

        @Override
        public RestaurantBuilders.Adress description(String description) {
            this.restaurant.description = description;
            return this;
        }

        @Override
        public RestaurantBuilders.MaximumOrders adress(String adress) {
            this.restaurant.adress = adress;
            return this;
        }

        @Override
        public RestaurantBuilders.Build maximumOrders(Integer maximumOrders) {
            this.restaurant.maximumOrders = maximumOrders;
            return this;
        }

        @Override
        public Restaurant build() {
            return restaurant;
        }
    }
}
