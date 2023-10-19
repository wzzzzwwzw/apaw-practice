package es.upm.miw.apaw_practice.domain.models.coffee_shop.composite;

public interface TreeCoffeeClients {
    Boolean isComposite();

    void add(TreeCoffeeClients treeCoffeeClients);

    void remove(TreeCoffeeClients treeCoffeeClients);
}
