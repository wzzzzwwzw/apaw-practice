package es.upm.miw.apaw_practice.domain.models.food_delivery;

public interface RestaurantBuilder {


    interface Name {
        Type name(String name);
    }

    interface Type {
        Description type(String type);
    }

    interface Description {
        Adress description(String description);
    }

    interface Adress {
        MaximumOrders adress(String adress);
    }

    interface MaximumOrders {
        Build maximumOrders(Integer maximumOrders);
    }

    interface Build {
        Restaurant build();
    }
}
