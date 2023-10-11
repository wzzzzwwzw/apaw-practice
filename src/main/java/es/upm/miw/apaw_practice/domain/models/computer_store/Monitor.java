package es.upm.miw.apaw_practice.domain.models.computer_store;

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

    public Monitor(String serialNumber, BigDecimal size, Integer refreshRate, List<Wire> wires) {
        this.serialNumber = serialNumber;
        this.size = size;
        this.refreshRate = refreshRate;
        this.wires = wires;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
    public Monitor onlySerialNumber(){
        Monitor monitor = new Monitor();
        monitor.setSerialNumber(this.getSerialNumber());
        return monitor;
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
}
