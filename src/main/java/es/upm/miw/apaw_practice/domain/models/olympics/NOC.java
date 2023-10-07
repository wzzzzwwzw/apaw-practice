package es.upm.miw.apaw_practice.domain.models.olympics;

import java.util.List;

public class NOC {
    private String code;
    private String committeeName;
    private Integer yearOfFoundation;
    private List<Athlete> athletes;

    public NOC() {
        // empty for framework
    }

    public NOC(String code, String committeeName, Integer yearOfFoundation, List<Athlete> athletes) {
        this.code = code;
        this.committeeName = committeeName;
        this.yearOfFoundation = yearOfFoundation;
        this.athletes = athletes;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCommitteeName() {
        return committeeName;
    }

    public void setCommitteeName(String committeeName) {
        this.committeeName = committeeName;
    }

    public Integer getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(Integer yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public List<Athlete> getAthletes() {
        return athletes;
    }

    public void setAthletes(List<Athlete> athletes) {
        this.athletes = athletes;
    }

    @Override
    public String toString() {
        return "NOC{" +
                "code='" + code + '\'' +
                ", committeeName='" + committeeName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", athletes=" + athletes +
                '}';
    }
}
