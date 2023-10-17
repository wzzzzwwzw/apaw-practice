package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities;

import es.upm.miw.apaw_practice.domain.models.car_dealership.Car;
import es.upm.miw.apaw_practice.domain.models.car_dealership.Dealership;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class DealershipEntity {
    @Id
    private String id;
    private String name;
    private String city;
    private String district;
    @DBRef
    private List<CarEntity> carEntities;

    public DealershipEntity(String name, String city, String district, List<CarEntity> carEntities) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.city = city;
        this.district = district;
        this.carEntities = carEntities;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public List<CarEntity> getCarEntities() {
        return carEntities;
    }

    public void setCarEntities(List<CarEntity> carEntities) {
        this.carEntities = carEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DealershipEntity that = (DealershipEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "DealershipEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", carEntities=" + carEntities +
                '}';
    }

    public Dealership toDealership() {
        Dealership dealership = new Dealership();
        BeanUtils.copyProperties(this, dealership);
        List<Car> cars = this.carEntities.stream()
                .map(CarEntity::toCar)
                .toList();
        dealership.setCarList(cars);
        return dealership;
    }
}
