package es.upm.miw.apaw_practice.domain.models.stable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Keeper {
    private String name;
    private Integer age;
    private LocalDate hireDate;
    private Double salary;
    private List<Horse> horses;

    public Keeper() {
    }

    public Keeper(String name, Integer age, LocalDate hireDate, Double salary) {
        this.name = name;
        this.age = age;
        this.hireDate = hireDate;
        this.salary = salary;
        this.horses = new ArrayList<>();
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

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSalary() {
        return salary;
    }


    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }

    public void addCareTask(Horse horse) {
        horses.add(horse);
    }

    public void removeCareTask(Horse horse) {
        horses.remove(horse);
    }

    @Override
    public String toString() {
        return "Keeper{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", horses=" + horses +
                '}';
    }
}