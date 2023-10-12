package es.upm.miw.apaw_practice.domain.models.computer_store;

import es.upm.miw.apaw_practice.domain.models.computer_store.builders.WireBuilders;

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

    public static class Builder implements WireBuilders.Name, WireBuilders.Optionals {
        private final Wire wire;

        public Builder() {
            this.wire = new Wire();
        }

        @Override
        public WireBuilders.Optionals name(String name) {
            this.wire.name = name;
            return this;
        }

        @Override
        public WireBuilders.Optionals length(BigDecimal length) {
            this.wire.length = length;
            return this;
        }

        @Override
        public WireBuilders.Optionals jacketMaterial(String jacketMaterial) {
            this.wire.jacketMaterial = jacketMaterial;
            return this;
        }

        @Override
        public Wire build() {
            return this.wire;
        }
    }
}
