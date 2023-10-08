package es.upm.miw.apaw_practice.domain.models.stable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class Horse {
    private String name;
    private Integer age;
    private LocalDate birthDate;
    private String race;
    private Double health;
    private BigDecimal purchasePrice;
    private Boolean sold;
    private List<Keeper> keepers;
    private CareTask careTask;

    public Horse() {

    }

    public Horse(String name, Integer age, LocalDate birthDate, String race, Double health, BigDecimal purchasePrice, Boolean sold, CareTask careTask) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.race = race;
        this.health = health;
        this.purchasePrice = purchasePrice;
        this.sold = sold;
        this.keepers = new ArrayList<>();
        this.careTask = careTask;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Double getHealth() {
        return health;
    }

    public void setHealth(Double health) {
        this.health = health;
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
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", race='" + race + '\'' +
                ", health=" + health +
                ", purchasePrice=" + purchasePrice +
                ", sold=" + sold +
                ", keepers=" + keepers +
                ", careTask=" + careTask +
                '}';
    }
}