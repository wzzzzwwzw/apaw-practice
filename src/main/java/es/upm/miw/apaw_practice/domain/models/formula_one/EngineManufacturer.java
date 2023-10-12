package es.upm.miw.apaw_practice.domain.models.formula_one;

public class EngineManufacturer {

    private String manufacturerName;
    private String engineBuiltIn;
    private Integer numberOfEnginesSupplied;

    public EngineManufacturer() {
        //empty for framework
    }

    public EngineManufacturer(String manufacturerName, String engineBuiltIn, Integer numberOfEnginesSupplied) {
        this.manufacturerName = manufacturerName;
        this.engineBuiltIn = engineBuiltIn;
        this.numberOfEnginesSupplied = numberOfEnginesSupplied;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getEngineBuiltIn() {
        return engineBuiltIn;
    }

    public void setEngineBuiltIn(String engineBuiltIn) {
        this.engineBuiltIn = engineBuiltIn;
    }

    public Integer getNumberOfEnginesSupplied() {
        return numberOfEnginesSupplied;
    }

    public void setNumberOfEnginesSupplied(Integer numberOfEnginesSupplied) {
        this.numberOfEnginesSupplied = numberOfEnginesSupplied;
    }

    @Override
    public String toString() {
        return "EngineManufacturer{" +
                "manufacturerName='" + manufacturerName + '\'' +
                ", engineBuiltIn='" + engineBuiltIn + '\'' +
                ", numberOfEnginesSupplied=" + numberOfEnginesSupplied +
                '}';
    }
}