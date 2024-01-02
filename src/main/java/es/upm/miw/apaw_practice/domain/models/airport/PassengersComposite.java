package es.upm.miw.apaw_practice.domain.models.airport;

import java.util.ArrayList;
import java.util.List;

public class PassengersComposite implements TreePassengers{

    private final String name;
    private final List<TreePassengers> treePassengers;

    public PassengersComposite(String name){
        this.name = name;
        this.treePassengers = new ArrayList<>();
    }

    @Override
    public Boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreePassengers treePassengers) {
        this.treePassengers.add(treePassengers);
    }

    @Override
    public void remove(TreePassengers treePassengers) {
        this.treePassengers.remove(treePassengers);
    }
    public List<TreePassengers> getTreePassengers(){
        return this.treePassengers;
    }

    @Override
    public String toString() {
        return "PassengersComopiste{" +
                "name='" + name + '\'' +
                ", treePassengers=" + treePassengers +
                '}';
    }
}
