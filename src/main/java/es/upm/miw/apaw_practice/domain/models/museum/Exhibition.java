package es.upm.miw.apaw_practice.domain.models.museum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Exhibition {
    private String exhibitionName;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<ArtWork> artWorks;

    public Exhibition() { }

    public Exhibition(String exhibitionName, String location, LocalDate startDate, LocalDate endDate, List<ArtWork> artWorks) {
        this.exhibitionName = exhibitionName;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.artWorks = artWorks;
    }

    public String getExhibitionName() {
        return exhibitionName;
    }

    public void setExhibitionName(String exhibitionName) {
        this.exhibitionName = exhibitionName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<ArtWork> getArtWorks() {
        return artWorks;
    }

    public void setArtWorks(List<ArtWork> artWorks) {
        this.artWorks = artWorks;
    }

    public void addArtWork(ArtWork artWork) {
        if (this.artWorks == null) {
            this.artWorks = new ArrayList<>();
        }
        this.artWorks.add(artWork);
    }
}
