package es.upm.miw.apaw_practice.domain.models.olympics;

public class Sport {
    private String sportName;
    private String governingBody;

    public Sport() {
        // empty for framework
    }

    public Sport(String sportName, String governingBody) {
        this.sportName = sportName;
        this.governingBody = governingBody;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getGoverningBody() {
        return governingBody;
    }

    public void setGoverningBody(String governingBody) {
        this.governingBody = governingBody;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "sportName='" + sportName + '\'' +
                ", governingBody='" + governingBody + '\'' +
                '}';
    }
}
