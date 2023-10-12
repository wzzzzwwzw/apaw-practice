package es.upm.miw.apaw_practice.domain.models.conference;

public class ConferenceLocation {
    private String id;
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

    public static ConferenceLocationBuilders.Id builder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                "id='" + id + '\'' +
                ", city='" + city + '\'' +
                ", building='" + building + '\'' +
                ", hall='" + hall + '\'' +
                '}';
    }

    public static class Builder implements ConferenceLocationBuilders.Id, ConferenceLocationBuilders.City, ConferenceLocationBuilders.Building, ConferenceLocationBuilders.Hall, ConferenceLocationBuilders.Build {

        private final ConferenceLocation conferenceLocation;

        public Builder() {
            this.conferenceLocation = new ConferenceLocation();
        }

        @Override
        public ConferenceLocationBuilders.City id(String id) {
            this.conferenceLocation.id = id;
            return this;
        }

        @Override
        public ConferenceLocationBuilders.Building city(String city) {
            this.conferenceLocation.city = city;
            return this;
        }

        @Override
        public ConferenceLocationBuilders.Hall building(String building) {
            this.conferenceLocation.building = building;
            return this;
        }

        @Override
        public ConferenceLocationBuilders.Build hall(String hall) {
            this.conferenceLocation.hall = hall;
            return this;
        }

        @Override
        public ConferenceLocation build() {
            return this.conferenceLocation;
        }
    }
}
