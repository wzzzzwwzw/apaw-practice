package es.upm.miw.apaw_practice.adapters.mongodb.airport.entities;

import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class PassengerEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private Integer age;
    private String numberOfPhone;


    public PassengerEntity() {
        //empty for framework
    }
    public PassengerEntity(Passenger passenger) {
        BeanUtils.copyProperties(passenger, this);
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

    public String getNumberOfPhone() {
        return numberOfPhone;
    }

    public void setNumberOfPhone(String numberOfPhone) {
        this.numberOfPhone = numberOfPhone;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    public Passenger toPassenger(){
        return new Passenger(this.name, this.age, this.numberOfPhone);
    }
    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((PassengerEntity) obj).name));
    }

    @Override
    public String toString() {
        return "PassengerEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", numberOfPhone='" + numberOfPhone + '\'' +
                '}';
    }
}
