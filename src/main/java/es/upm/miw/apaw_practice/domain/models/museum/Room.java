package es.upm.miw.apaw_practice.domain.models.museum;

public class Room {
    private String description;
    private Integer floor;
    private Double popularity;

    public Room() { }

    public Room(String description, Integer floor, Double popularity) {
        this.description = description;
        this.floor = floor;
        this.popularity = popularity;
    }

    public RoomBuilder.Description builder() {
        return new Room.Builder();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }


    private interface RoomBuilder {
        interface Description {
            Floor description(String description);
        }

        interface Floor {
            Popularity floor(Integer floor);
        }

        interface Popularity {
            Popularity popularity(Double popularity);
            Room build();
        }
    }

    private static class Builder implements RoomBuilder.Description, RoomBuilder.Floor, RoomBuilder.Popularity {
        private final Room room;

        public Builder() {
            this.room = new Room();
        }

        @Override
        public RoomBuilder.Floor description(String description) {
            this.room.setDescription(description);
            return this;
        }

        @Override
        public RoomBuilder.Popularity floor(Integer floor) {
            this.room.setFloor(floor);
            return this;
        }

        @Override
        public RoomBuilder.Popularity popularity(Double popularity) {
            this.room.setPopularity(popularity);
            return this;
        }

        @Override
        public Room build() {
            return this.room;
        }
    }
}
