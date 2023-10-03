package es.upm.miw.apaw_practice.domain.models.car_workshop;

import java.util.ArrayList;
import java.util.List;

public class CarToRepair {
    private String registrationNumber;
    private String model;
    private String brand;
    private List<Invoice> invoices;
    private Mechanic mechanic;

    public CarToRepair() {
        this.invoices = new ArrayList<Invoice>();
    }

    public CarToRepair(String registrationNumber, String model, String brand, Mechanic mechanic) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.brand = brand;
        this.mechanic = mechanic;
        this.invoices = new ArrayList<Invoice>();
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }
}
