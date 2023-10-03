package es.upm.miw.apaw_practice.domain.models.car_workshop;

import java.util.ArrayList;
import java.util.List;

public class CarToRepair {
    private String registrationNumber;
    private String model;
    private String brand;
    private List<OBDFault> obdFaults;

    public CarToRepair() {
        obdFaults = new ArrayList<OBDFault>();
    }

    public CarToRepair(String registrationNumber, String model, String brand, List<OBDFault> obdFaults) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.brand = brand;
        this.obdFaults = obdFaults;
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

    public List<OBDFault> getObdFaults() {
        return obdFaults;
    }

    public void setObdFaults(List<OBDFault> obdFaults) {
        this.obdFaults = obdFaults;
    }

}
