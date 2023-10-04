package es.upm.miw.apaw_practice.domain.models.formula_one;

public class DrivingStyle {

    private String id;
    private Integer aggressiveness;
    private Integer consistency;
    private Integer adaptability;
    private Integer tireManagement;
    private Integer fuelManagement;

    public DrivingStyle() {
        //empty for framework
    }

    public DrivingStyle(Integer aggressiveness, Integer consistency, Integer adaptability, Integer tireManagement, Integer fuelManagement) {
        this.aggressiveness = aggressiveness;
        this.consistency = consistency;
        this.adaptability = adaptability;
        this.tireManagement = tireManagement;
        this.fuelManagement = fuelManagement;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAggressiveness() {
        return aggressiveness;
    }

    public void setAggressiveness(Integer aggressiveness) {
        assert aggressiveness >= 0 && aggressiveness <= 100;

        this.aggressiveness = aggressiveness;
    }

    public Integer getConsistency() {
        return consistency;
    }

    public void setConsistency(Integer consistency) {
        assert consistency >= 0 && consistency <= 100;

        this.consistency = consistency;
    }

    public Integer getAdaptability() {
        return adaptability;
    }

    public void setAdaptability(Integer adaptability) {
        assert adaptability >= 0 && adaptability <= 100;

        this.adaptability = adaptability;
    }

    public Integer getTireManagement() {
        return tireManagement;
    }

    public void setTireManagement(Integer tireManagement) {
        assert tireManagement >= 0 && tireManagement <= 100;

        this.tireManagement = tireManagement;
    }

    public Integer getFuelManagement() {
        return fuelManagement;
    }

    public void setFuelManagement(Integer fuelManagement) {
        assert fuelManagement >= 0 && fuelManagement <= 100;

        this.fuelManagement = fuelManagement;
    }

    @Override
    public String toString() {
        return "DrivingStyle{" +
                "id='" + id + '\'' +
                ", aggressiveness=" + aggressiveness +
                ", consistency=" + consistency +
                ", adaptability=" + adaptability +
                ", tireManagement=" + tireManagement +
                ", fuelManagement=" + fuelManagement +
                '}';
    }
}