package es.upm.miw.apaw_practice.domain.models.car_dealership;

public class Seller {
    private String name;
    private String surname;
    private Integer salary;

    public Seller(String name, String surname, Integer salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
