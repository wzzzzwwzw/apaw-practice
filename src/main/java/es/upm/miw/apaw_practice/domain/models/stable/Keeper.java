package es.upm.miw.apaw_practice.domain.models.stable;

import java.time.LocalDate;

public class Keeper {
    private String name;
    private int age;
    private LocalDate hireDate;
    private double salary;

    public Keeper(String name, int age, LocalDate hireDate, double salary) {
        this.name = name;
        this.age = age;
        this.hireDate = hireDate;
        this.salary = salary;
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

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}