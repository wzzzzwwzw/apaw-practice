package es.upm.miw.apaw_practice.domain.models.computer_store;

import java.math.BigDecimal;

public class Wire {
    private String name;
    private BigDecimal length;
    private String jacketMaterial;

    public Wire() {
    }

    public Wire(String name, BigDecimal length, String jacketMaterial) {
        this.name = name;
        this.length = length;
        this.jacketMaterial = jacketMaterial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public String getJacketMaterial() {
        return jacketMaterial;
    }

    public void setJacketMaterial(String jacketMaterial) {
        this.jacketMaterial = jacketMaterial;
    }

    @Override
    public String toString() {
        return "Wire{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", jacketMaterial='" + jacketMaterial + '\'' +
                '}';
    }
}
