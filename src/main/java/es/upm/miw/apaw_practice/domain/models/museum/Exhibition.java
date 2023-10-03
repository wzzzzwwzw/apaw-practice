package es.upm.miw.apaw_practice.domain.models.museum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Exhibition {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<ArtWork> artWorks;

    public Exhibition() { }

    public Exhibition(String name, LocalDate startDate, LocalDate endDate, List<ArtWork> artWorks) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.artWorks = artWorks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void addArtWork(ArtWork artWork) {
        if (this.artWorks == null) {
            this.artWorks = new ArrayList<>();
        }
        this.artWorks.add(artWork);
    }
}
