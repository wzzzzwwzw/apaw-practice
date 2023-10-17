package es.upm.miw.apaw_practice.adapters.mongodb.stable.entities;

import es.upm.miw.apaw_practice.domain.models.stable.Keeper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Document
public class KeeperEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private Integer age;
    private LocalDate hireDate;
    private Double salary;

    public KeeperEntity() {
        //Empty for framework
    }

    public KeeperEntity(Keeper keeper) {
        BeanUtils.copyProperties(keeper, this);
        this.id = UUID.randomUUID().toString();
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

    public Keeper toKeeper() {
        Keeper keeper = new Keeper();
        BeanUtils.copyProperties(this, keeper);
        return keeper;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeeperEntity that = (KeeperEntity) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "KeeperEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                '}';
    }
}
