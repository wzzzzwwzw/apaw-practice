package es.upm.miw.apaw_practice.domain.models.stable;

import java.time.LocalDate;

public class Keeper {
    private String name;
    private Integer age;
    private LocalDate hireDate;
    private Double salary;

    public Keeper() {
    }

    public Keeper(String name, Integer age, LocalDate hireDate, Double salary) {
        this.name = name;
        this.age = age;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public Keeper(Keeper keeper) {
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

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Keeper{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                '}';
    }
}