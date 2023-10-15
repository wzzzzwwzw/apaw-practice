package es.upm.miw.apaw_practice.domain.models.car_workshop;

public class OBDFault implements TreeOBDFaults{
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

    public Boolean getIsITVSafe() {
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

    @Override
    public String toString() {
        return "OBDFault{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", isITVSafe=" + isITVSafe +
                ", solution='" + solution + '\'' +
                '}';
    }

    @Override
    public String family() {
        return this.code;
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public void add(TreeOBDFaults treeOBDFaults) {
        // Do nothing because is not composite
    }

    @Override
    public void remove(TreeOBDFaults treeOBDFaults) {
        // Do nothing because is not composite
    }

    public static class Builder implements OBDFaultsBuilders.Code, OBDFaultsBuilders.Optionals {

        private final OBDFault obdFault;

        public Builder() {
            obdFault = new OBDFault();
        }

        @Override
        public OBDFaultsBuilders.Optionals code(String code) {
            this.obdFault.code = code;
            return this;
        }

        @Override
        public OBDFaultsBuilders.Optionals description(String description) {
            this.obdFault.description = description;
            return this;
        }

        @Override
        public OBDFaultsBuilders.Optionals isITVSafe(Boolean isITVSafe) {
            this.obdFault.isITVSafe = isITVSafe;
            return this;
        }

        @Override
        public OBDFaultsBuilders.Optionals solution(String solution) {
            this.obdFault.solution = solution;
            return this;
        }

        @Override
        public OBDFault build() {
            return this.obdFault;
        }
    }
}
