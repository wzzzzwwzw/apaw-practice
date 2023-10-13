package es.upm.miw.apaw_practice.domain.models.food_delivery;

import java.util.ArrayList;
import java.util.List;

public class RestaurantComposite implements TreeRestaurants {

    private final String referenceName;
    private final List<TreeRestaurants> treeRestaurantsList;


    public RestaurantComposite(String referenceName) {
        this.referenceName = referenceName;
        this.treeRestaurantsList = new ArrayList<>();
    }


    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreeRestaurants treeRestaurants) {
        treeRestaurantsList.add(treeRestaurants);
    }

    @Override
    public void remove(TreeRestaurants treeRestaurants) {
        treeRestaurantsList.remove(treeRestaurants);

    }


    @Override
    public String toString() {
        return "RestaurantComposite{" +
                "referenceName='" + referenceName + '\'' +
                ", treeRestaurantsList=" + treeRestaurantsList +
                '}';
    }
}
