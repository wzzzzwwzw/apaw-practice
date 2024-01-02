package es.upm.miw.apaw_practice.domain.models.computer_store;

import es.upm.miw.apaw_practice.domain.models.computer_store.builders.MonitorBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Monitor {
    private String serialNumber;
    private BigDecimal size;
    private Integer refreshRate;
    private List<Wire> wires;

    public Monitor() {
        wires = new ArrayList<>();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public Integer getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(Integer refreshRate) {
        this.refreshRate = refreshRate;
    }

    public List<Wire> getWires() {
        return wires;
    }

    public void setWires(List<Wire> wires) {
        this.wires = wires;
    }

    public void addWire(Wire wire) {
        this.wires.add(wire);
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "serialNumber='" + serialNumber + '\'' +
                ", size=" + size +
                ", refreshRate=" + refreshRate +
                ", wires=" + wires +
                '}';
    }

    public static class Builder implements MonitorBuilders.SerialNumber, MonitorBuilders.Optionals {
        private final Monitor monitor;

        public Builder() {
            monitor = new Monitor();
        }

        @Override
        public MonitorBuilders.Optionals serialNumber(String serialNumber) {
            this.monitor.serialNumber = serialNumber;
            return this;
        }

        @Override
        public MonitorBuilders.Optionals size(BigDecimal size) {
            this.monitor.size = size;
            return this;
        }

        @Override
        public MonitorBuilders.Optionals refreshRate(Integer refreshRate) {
            this.monitor.refreshRate = refreshRate;
            return this;
        }

        @Override
        public MonitorBuilders.Optionals wires(List<Wire> wires) {
            this.monitor.wires = wires;
            return this;
        }

        @Override
        public Monitor build() {
            return this.monitor;
        }
    }
}
