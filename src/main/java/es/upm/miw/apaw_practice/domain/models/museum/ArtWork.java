package es.upm.miw.apaw_practice.domain.models.museum;

public class ArtWork {
    private String inventoryNumber;
    private String title;
    private Integer approximateYear;
    private Boolean exhibited;
    private Room room;

    public ArtWork() { }

    public ArtWork(String inventoryNumber, String title, Integer approximateYear, Boolean exhibited, Room room) {
        this.inventoryNumber = inventoryNumber;
        this.title = title;
        this.approximateYear = approximateYear;
        this.exhibited = exhibited;
        this.room = room;
    }

    public ArtWorkBuilder.InventoryNumber builder() {
        return new ArtWork.Builder();
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getApproximateYear() {
        return approximateYear;
    }

    public void setApproximateYear(Integer approximateYear) {
        this.approximateYear = approximateYear;
    }

    public Boolean isExhibited() {
        return exhibited;
    }

    public void setExhibited(Boolean exhibited) {
        this.exhibited = exhibited;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }


    private interface ArtWorkBuilder {
        interface InventoryNumber {
            Title inventoryNumber(String inventoryNumber);
        }

        interface Title {
            ApproximateYear title(String title);
        }

        interface ApproximateYear {
            Exhibited approximateYear(Integer approximateYear);
        }

        interface Exhibited {
            RoomBuilder exhibited(Boolean exhibited);
        }

        interface RoomBuilder {
            RoomBuilder room(Room room);
            ArtWork build();
        }
    }

    private static class Builder implements ArtWorkBuilder.InventoryNumber, ArtWorkBuilder.Title, ArtWorkBuilder.ApproximateYear, ArtWorkBuilder.Exhibited, ArtWorkBuilder.RoomBuilder {
        private final ArtWork artWork;

        public Builder() {
            this.artWork = new ArtWork();
        }

        @Override
        public ArtWorkBuilder.Title inventoryNumber(String inventoryNumber) {
            this.artWork.setInventoryNumber(inventoryNumber);
            return this;
        }

        @Override
        public ArtWorkBuilder.ApproximateYear title(String title) {
            this.artWork.setTitle(title);
            return this;
        }

        @Override
        public ArtWorkBuilder.Exhibited approximateYear(Integer approximateYear) {
            this.artWork.setApproximateYear(approximateYear);
            return this;
        }

        @Override
        public ArtWorkBuilder.RoomBuilder exhibited(Boolean exhibited) {
            this.artWork.setExhibited(exhibited);
            return this;
        }

        @Override
        public ArtWorkBuilder.RoomBuilder room(Room room) {
            this.artWork.setRoom(room);
            return this;
        }

        @Override
        public ArtWork build() {
            return this.artWork;
        }
    }
}
