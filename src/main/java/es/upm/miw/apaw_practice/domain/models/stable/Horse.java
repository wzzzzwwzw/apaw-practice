package es.upm.miw.apaw_practice.domain.models.stable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Horse {
    private String name;
    private int age;
    private LocalDate birthDate;
    private String race;
    private double health;
    private double purchasePrice;
    private boolean sold;
    private Keeper keeper;
    private List<CareTask> careTasks;

    public Horse(String name, int age, LocalDate birthDate, String race, double health, double purchasePrice, boolean sold) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.race = race;
        this.health = health;
        this.purchasePrice = purchasePrice;
        this.sold = sold;
        this.careTasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
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

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public Keeper getKeeper() {
        return keeper;
    }

    public void setKeeper(Keeper keeper) {
        this.keeper = keeper;
    }

    public List<CareTask> getCareTasks() {
        return careTasks;
    }

    public void setCareTasks(List<CareTask> careTasks) {
        this.careTasks = careTasks;
    }

    public void assignKeeper(Keeper keeper) {
        this.keeper = keeper;
    }

    public void addCareTask(CareTask careTask) {
        careTasks.add(careTask);
    }

    public void removeCareTask(CareTask careTask) {
        careTasks.remove(careTask);
    }
}