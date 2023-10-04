package es.upm.miw.apaw_practice.domain.models.car_dealership;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Car {
    private String chassisNumber;
    private BigDecimal price;
    private Boolean sold;
    private LocalDate fabricationDate;
    private CarModel carModel;
    private List<Seller> sellerList;

    public Car(String chassisNumber, BigDecimal price, Boolean sold, LocalDate fabricationDate, CarModel carModel) {
        this.chassisNumber = chassisNumber;
        this.price = price;
        this.sold = sold;
        this.fabricationDate = fabricationDate;
        this.carModel = carModel;
        this.sellerList = new ArrayList<>();
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

    public List<Seller> getSellerList() {
        return sellerList;
    }

    public void setSellerList(List<Seller> sellerList) {
        this.sellerList = sellerList;
    }

    public void setSeller(Seller seller) {
        this.sellerList.add(seller);
    }

    @Override
    public String toString() {
        return "Car{" +
                "chassisNumber='" + chassisNumber + '\'' +
                ", price=" + price +
                ", sold=" + sold +
                ", fabricationDate=" + fabricationDate +
                ", carModel=" + carModel +
                ", sellerList=" + sellerList +
                '}';
    }
}
