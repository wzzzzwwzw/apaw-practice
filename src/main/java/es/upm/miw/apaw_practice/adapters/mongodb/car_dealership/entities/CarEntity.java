package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities;

import es.upm.miw.apaw_practice.domain.models.car_dealership.CarModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class CarEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String chassisNumber;
    private BigDecimal price;
    private Boolean sold;
    private LocalDate fabricationDate;
    private CarModel carModel;
    @DBRef
    private List<SellerEntity> sellerEntities;

    public CarEntity(String chassisNumber, BigDecimal price, Boolean sold, LocalDate fabricationDate, CarModel carModel, List<SellerEntity> sellerEntities) {
        this.id = UUID.randomUUID().toString();
        this.chassisNumber = chassisNumber;
        this.price = price;
        this.sold = sold;
        this.fabricationDate = fabricationDate;
        this.carModel = carModel;
        this.sellerEntities = sellerEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    public LocalDate getFabricationDate() {
        return fabricationDate;
    }

    public void setFabricationDate(LocalDate fabricationDate) {
        this.fabricationDate = fabricationDate;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public List<SellerEntity> getSellerEntities() {
        return sellerEntities;
    }

    public void setSellerEntities(List<SellerEntity> sellerEntities) {
        this.sellerEntities = sellerEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarEntity carEntity = (CarEntity) o;
        return Objects.equals(chassisNumber, carEntity.chassisNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chassisNumber);
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "id='" + id + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", price=" + price +
                ", sold=" + sold +
                ", fabricationDate=" + fabricationDate +
                ", carModel=" + carModel +
                ", sellerEntities=" + sellerEntities +
                '}';
    }
}
