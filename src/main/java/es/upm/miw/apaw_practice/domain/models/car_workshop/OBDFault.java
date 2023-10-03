package es.upm.miw.apaw_practice.domain.models.car_workshop;

public class OBDFault {
    private String code;
    private String description;
    private boolean canPassITV;
    private String solution;

    public OBDFault() {
        // empty for framework
    }

    public OBDFault(String code, String description, boolean canPassITV, String solution) {
        this.code = code;
        this.description = description;
        this.canPassITV = canPassITV;
        this.solution = solution;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCanPassITV() {
        return canPassITV;
    }

    public void setCanPassITV(boolean canPassITV) {
        this.canPassITV = canPassITV;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

}
