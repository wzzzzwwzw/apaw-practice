package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities;

import es.upm.miw.apaw_practice.domain.models.car_dealership.Seller;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class SellerEntity {
    @Id
    private String id;
    private String name;
    private String surname;
    private Integer salary;

    public SellerEntity(String name, String surname, Integer salary) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Seller toSeller() {
        Seller seller = new Seller();
        BeanUtils.copyProperties(this, seller);
        return seller;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerEntity that = (SellerEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
