package es.upm.miw.apaw_practice.domain.models.stable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Horse {
    private String name;
    private Integer age;
    private LocalDate birthDate;
    private String race;
    private Double health;
    private Double purchasePrice;
    private Boolean sold;
    private List<Keeper> keepers;
    private List<CareTask> careTasks;

    public Horse() {

    }

    public Horse(String name, Integer age, LocalDate birthDate, String race, Double health, Double purchasePrice, Boolean sold) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.race = race;
        this.health = health;
        this.purchasePrice = purchasePrice;
        this.sold = sold;
        this.keepers = new ArrayList<>();
        this.careTasks = new ArrayList<>();
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

    public void setAge(int age) {
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

    public void setHealth(double health) {
        this.health = health;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public List<Keeper> getKeepers() {
        return keepers;
    }

    public void setHorses(List<Keeper> keepers) {
        this.keepers = keepers;
    }

    public List<CareTask> getCareTasks() {
        return careTasks;
    }

    public void setCareTasks(List<CareTask> careTasks) {
        this.careTasks = careTasks;
    }

    public void addKeeper(Keeper keeper) {
        keepers.add(keeper);
    }

    public void removeKeeper(Keeper keeper) {
        keepers.remove(keeper);
    }

    public void addCareTask(CareTask careTask) {
        careTasks.add(careTask);
    }

    public void removeCareTask(CareTask careTask) {
        careTasks.remove(careTask);
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
                ", careTasks=" + careTasks +
                '}';
    }
}