package es.upm.miw.apaw_practice.domain.models.furniture_store;

import java.util.ArrayList;
import java.util.List;

public class FurnitureComposite implements TreeFurniture{

    private final String name;
    private final List<TreeFurniture> treeFurnitures;

    public FurnitureComposite(String name) {
        this.name = name;
        this.treeFurnitures = new ArrayList<>();
    }

    @Override
    public void add(TreeFurniture treeFurniture) {
        this.treeFurnitures.add(treeFurniture);
    }

    @Override
    public void remove(TreeFurniture treeFurniture) {
        this.treeFurnitures.remove(treeFurniture);
    }

    @Override
    public String toString() {
        return "FurnitureComposite{" +
                "name='" + name + '\'' +
                ", treeFurnitures=" + treeFurnitures +
                '}';
    }

}
