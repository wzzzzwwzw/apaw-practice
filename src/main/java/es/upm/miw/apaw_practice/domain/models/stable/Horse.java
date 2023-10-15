package es.upm.miw.apaw_practice.domain.models.stable;

import java.util.List;
import java.math.BigDecimal;

public class Horse {
    private String name;
    private BigDecimal purchasePrice;
    private Boolean sold;
    private List<Keeper> keepers;
    private CareTask careTask;

    public Horse() {

    }

    public Horse(String name, BigDecimal purchasePrice, Boolean sold, List<Keeper> keepers, CareTask careTask) {
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.sold = sold;
        this.keepers = keepers;
        this.careTask = careTask;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    public List<Keeper> getKeepers() {
        return keepers;
    }
    public void setKeepers(List<Keeper> keepers) {
        this.keepers = keepers;
    }

    public CareTask getCareTask() {
        return careTask;
    }

    public void setCareTask(CareTask careTask) {
        this.careTask = careTask;
    }

    public void addKeeper(Keeper keeper) {
        keepers.add(keeper);
    }

    public void removeKeeper(Keeper keeper) {
        keepers.remove(keeper);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", sold=" + sold +
                ", keepers=" + keepers +
                ", careTask=" + careTask +
                '}';
    }
}