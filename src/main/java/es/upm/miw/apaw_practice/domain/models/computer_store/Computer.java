package es.upm.miw.apaw_practice.domain.models.computer_store;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private String name;
    private BigDecimal cost;
    private BigDecimal weight;
    private List<Monitor> monitors;

    public Computer() {
        monitors = new ArrayList<>();
    }

    public Computer(String name, BigDecimal cost, BigDecimal weight, List<Monitor> monitors) {
        this.name = name;
        this.cost = cost;
        this.weight = weight;
        this.monitors = monitors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public List<Monitor> getMonitors() {
        return monitors;
    }

    public void setMonitors(List<Monitor> monitors) {
        this.monitors = monitors;
    }

    public void addMonitor(Monitor monitor) {
        this.monitors.add(monitor);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                ", monitors=" + monitors +
                '}';
    }
}
