package es.upm.miw.apaw_practice.domain.models.car_workshop;

public class OBDFault {
    private String code;
    private String description;
    private Boolean isITVSafe;
    private String solution;

    public OBDFault() {
        // empty for framework
    }

    public OBDFault(String code, String description, Boolean isITVSafe, String solution) {
        this.code = code;
        this.description = description;
        this.isITVSafe = isITVSafe;
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

    public Boolean isCanPassITV() {
        return isITVSafe;
    }

    public void setIsITVSafe(Boolean isITVSafe) {
        this.isITVSafe = isITVSafe;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

}
