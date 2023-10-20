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

    public Car() {
        this.sellerList = new ArrayList<>();
    }
    public Car(String chassisNumber, BigDecimal price, Boolean sold, LocalDate fabricationDate, CarModel carModel) {
        this();
        this.chassisNumber = chassisNumber;
        this.price = price;
        this.sold = sold;
        this.fabricationDate = fabricationDate;
        this.carModel = carModel;
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

    public void addSeller(Seller seller) {
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
    public static class CarBuilder {
        private final Car car;

        public CarBuilder() {
            this.car = new Car();
        }

        public CarBuilder chassisNumber(String chassisNumber) {
            this.car.setChassisNumber(chassisNumber);
            return this;
        }

        public CarBuilder price(BigDecimal price) {
            this.car.setPrice(price);
            return this;
        }

        public CarBuilder sold(Boolean sold) {
            this.car.setSold(sold);
            return this;
        }

        public CarBuilder fabricationDate(LocalDate fabricationDate) {
            this.car.setFabricationDate(fabricationDate);
            return this;
        }

        public CarModel.CarModelBuilder carModel() {
            return new CarModel.CarModelBuilder(this);
        }

        void addCarModel(CarModel carModel) {
            this.car.setCarModel(carModel);
        }

        public Seller.SellerBuilder seller() {
            return new Seller.SellerBuilder(this);
        }

        void addSeller(Seller seller) {
            this.car.addSeller(seller);
        }

        public Car build() {
            return this.car;
        }
    }
}
