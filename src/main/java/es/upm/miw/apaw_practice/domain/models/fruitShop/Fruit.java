package es.upm.miw.apaw_practice.domain.models.fruitShop;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.List;

public class Fruit {


    private String type;

    private BigDecimal unitPrice;

    private Boolean isTropical;

    private LocalDate stockTime;

    private FruitSpecies fruitSpecies;

    private List<Customer> customer;

    public Fruit() {
        //empty for framework
    }


    public Fruit(String type, BigDecimal unitPrice, Boolean isTropical, LocalDate stockTime, FruitSpecies fruitSpecies, List<Customer> customer) {
        this.type = type;
        this.unitPrice = unitPrice;
        this.isTropical = isTropical;
        this.stockTime = stockTime;
        this.fruitSpecies = fruitSpecies;
        this.customer = customer;
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

    public Boolean getTropical() {
        return isTropical;
    }

    public void setTropical(Boolean tropical) {
        isTropical = tropical;
    }

    public LocalDate getStockTime() {
        return stockTime;
    }

    public void setStockTime(LocalDate stockTime) {
        this.stockTime = stockTime;
    }

    public FruitSpecies getFruitSpecies() {
        return fruitSpecies;
    }

    public void setFruitSpecies(FruitSpecies fruitSpecies) {
        this.fruitSpecies = fruitSpecies;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "type='" + type + '\'' +
                ", unitPrice=" + unitPrice +
                ", isTropical=" + isTropical +
                ", stockTime=" + stockTime +
                ", fruitSpecies=" + fruitSpecies +
                ", customer=" + customer +
                '}';
    }
}
