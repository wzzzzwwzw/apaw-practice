package es.upm.miw.apaw_practice.domain.models.museum;

public class ArtWork {
    private String inventoryNumber;
    private String title;
    private Integer approximateYear;
    private Boolean exhibited;
    private Author author;
    private Room room;

    public ArtWork() { }

    public ArtWork(String inventoryNumber, String title, Integer approximateYear, Boolean exhibited, Author author, Room room) {
        this.inventoryNumber = inventoryNumber;
        this.title = title;
        this.approximateYear = approximateYear;
        this.exhibited = exhibited;
        this.author = author;
        this.room = room;
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

    public Boolean getExhibited() {
        return exhibited;
    }

    public void setExhibited(Boolean exhibited) {
        this.exhibited = exhibited;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
