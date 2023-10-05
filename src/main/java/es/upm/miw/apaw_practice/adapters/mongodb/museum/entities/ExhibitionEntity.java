package es.upm.miw.apaw_practice.adapters.mongodb.museum.entities;

import es.upm.miw.apaw_practice.domain.models.museum.ArtWork;
import es.upm.miw.apaw_practice.domain.models.museum.Exhibition;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Document
public class ExhibitionEntity {
    @Id
    private String exhibitionName;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    @DBRef
    private List<ArtWorkEntity> artWorks;

    public ExhibitionEntity() {
        // Empty for framework
    }

    public ExhibitionEntity(String exhibitionName, String location, LocalDate startDate, LocalDate endDate, List<ArtWorkEntity> artWorks) {
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

    public List<ArtWorkEntity> getArtWorks() {
        return artWorks;
    }

    public void setArtWorks(List<ArtWorkEntity> artWorks) {
        this.artWorks = artWorks;
    }

    public void fromExhibition(Exhibition exhibition) {
        BeanUtils.copyProperties(exhibition, this);
    }

    public Exhibition toExhibition() {
        Exhibition exhibition = new Exhibition();
        BeanUtils.copyProperties(this, exhibition, "artWorks");
        List<ArtWork> artWorks = this.artWorks.stream()
                .map(ArtWorkEntity::toArtWork)
                .toList();
        exhibition.setArtWorks(artWorks);
        return exhibition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExhibitionEntity that = (ExhibitionEntity) o;
        return Objects.equals(exhibitionName, that.exhibitionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exhibitionName);
    }

    @Override
    public String toString() {
        return "ExhibitionEntity{" +
                "exhibitionName='" + exhibitionName + '\'' +
                ", location='" + location + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", artWorks=" + artWorks +
                '}';
    }
}
