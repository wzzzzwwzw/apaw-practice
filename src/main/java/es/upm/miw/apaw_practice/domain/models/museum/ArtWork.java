package es.upm.miw.apaw_practice.domain.models.museum;

public class ArtWork {
    private String inventoryNumber;
    private String title;
    private Integer approximateYear;
    private Boolean isExhibited;
    private Author author;


    public ArtWork() { }

    public ArtWork(String inventoryNumber, String title, Integer approximateYear, Boolean isExhibited, Author author) {
        this.inventoryNumber = inventoryNumber;
        this.title = title;
        this.approximateYear = approximateYear;
        this.isExhibited = isExhibited;
        this.author = author;
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
        return isExhibited;
    }

    public void setExhibited(Boolean exhibited) {
        isExhibited = exhibited;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
