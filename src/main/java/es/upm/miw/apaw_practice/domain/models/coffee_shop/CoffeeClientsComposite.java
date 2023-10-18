package es.upm.miw.apaw_practice.domain.models.coffee_shop;

import es.upm.miw.apaw_practice.domain.models.coffee_shop.composite.TreeCoffeeClients;

import java.util.ArrayList;
import java.util.List;

public class CoffeeClientsComposite implements TreeCoffeeClients {
    private final String name;
    private final List<TreeCoffeeClients> treeCoffeeClients;

    public CoffeeClientsComposite(String name) {
        this.name = name;
        this.treeCoffeeClients = new ArrayList<>();
    }

    @Override
    public Boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreeCoffeeClients treeCoffeeClients) {
        this.treeCoffeeClients.add(treeCoffeeClients);
    }

    @Override
    public void remove(TreeCoffeeClients treeCoffeeClients) {
        this.treeCoffeeClients.remove(treeCoffeeClients);
    }

    public List<TreeCoffeeClients> getTreeCoffeeClients() {
        return treeCoffeeClients;
    }

    @Override
    public String toString() {
        return "CoffeeClientsComposite{" +
                "name='" + name + '\'' +
                ", treeCoffeeClients=" + treeCoffeeClients +
                '}';
    }
}
