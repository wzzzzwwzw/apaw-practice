package es.upm.miw.apaw_practice.domain.models.food_delivery;

public interface TreeRestaurants {

    boolean isComposite();

    void add(TreeRestaurants treeRestaurants);

    void remove(TreeRestaurants treeRestaurants);
}
