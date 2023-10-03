package es.upm.miw.apaw_practice.domain.models.conference;

public class ConferenceLocation {
    private String city;
    private String building;
    private String hall;

    public ConferenceLocation() {
        //empty for framework
    }

    public ConferenceLocation(String city, String building, String hall) {
        this.city = city;
        this.building = building;
        this.hall = hall;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    @Override
    public String toString() {
        return "ConferenceLocation{" +
                "city='" + city + '\'' +
                ", building='" + building + '\'' +
                ", hall='" + hall + '\'' +
                '}';
    }
}
