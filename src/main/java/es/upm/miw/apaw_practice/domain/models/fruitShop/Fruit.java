package es.upm.miw.apaw_practice.domain.models.fruitShop;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.List;

public class Fruit {


    private String type;

    private BigDecimal unitPrice;

    private Boolean tropical;

    private LocalDate stockTime;

    private FruitSpecie fruitSpecie;

    private List<Customer> customers;

    public Fruit() {
        //empty for framework
    }

    
    public Fruit(String type, BigDecimal unitPrice, Boolean tropical, LocalDate stockTime, FruitSpecie fruitSpecie, List<Customer> customers) {
        this.type = type;
        this.unitPrice = unitPrice;
        this.tropical = tropical;
        this.stockTime = stockTime;
        this.fruitSpecie = fruitSpecie;
        this.customers = customers;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Boolean isTropical() {
        return tropical;
    }

    public void setTropical(Boolean tropical) {
        this.tropical = tropical;
    }

    public LocalDate getStockTime() {
        return stockTime;
    }

    public void setStockTime(LocalDate stockTime) {
        this.stockTime = stockTime;
    }

    public FruitSpecie getFruitSpecie() {
        return fruitSpecie;
    }

    public void setFruitSpecie(FruitSpecie fruitSpecie) {
        this.fruitSpecie = fruitSpecie;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "type='" + type + '\'' +
                ", unitPrice=" + unitPrice +
                ", tropical=" + tropical +
                ", stockTime=" + stockTime +
                ", fruitSpecie=" + fruitSpecie +
                ", customers=" + customers +
                '}';
    }
}
