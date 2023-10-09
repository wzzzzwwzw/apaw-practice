package es.upm.miw.apaw_practice.domain.models.olympics;

public class Athlete {
    private Integer bib;
    private String familyName;
    private String gender;

    public Athlete() {
        // empty for framework
    }

    public Athlete(Integer bib, String familyName, String gender) {
        this.bib = bib;
        this.familyName = familyName;
        this.gender = gender;
    }

    public Integer getBib() {
        return bib;
    }

    public void setBib(Integer bib) {
        this.bib = bib;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "bib=" + bib +
                ", familyName='" + familyName + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
