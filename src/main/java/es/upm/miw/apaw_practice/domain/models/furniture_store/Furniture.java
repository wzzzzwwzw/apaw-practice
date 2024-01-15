package es.upm.miw.apaw_practice.domain.models.furniture_store;

import java.math.BigDecimal;
import java.util.List;

public class Furniture implements TreeFurniture {
    private String name;
    private BigDecimal price;
    private List<Material> materials;

    public Furniture() {
        //empty from framework
    }

    public Furniture(String name, BigDecimal price, List<Material> materials) {
        this.name = name;
        this.price = price;
        this.materials = materials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", materials=" + materials +
                '}';
    }

    @Override
    public void add(TreeFurniture treeFurniture) {
        throw new UnsupportedOperationException("Unsupported operation in leaf");
    }

    @Override
    public void remove(TreeFurniture treeFurniture) {
        // Do nothing in leaf
    }

}
