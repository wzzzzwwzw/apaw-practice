package es.upm.miw.apaw_practice.adapters.mongodb.museum.entities;

import es.upm.miw.apaw_practice.domain.models.museum.ArtWork;
import es.upm.miw.apaw_practice.domain.models.museum.Painter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class PainterEntity {
    @Id
    private String id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private LocalDate deathDate;
    @DBRef
    private List<ArtWorkEntity> artWorks;

    public PainterEntity() {
        // Empty for framework
    }

    public PainterEntity(String name, String surname, LocalDate birthDate, LocalDate deathDate, List<ArtWorkEntity> artWorks) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.artWorks = artWorks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public List<ArtWorkEntity> getArtWorks() {
        return artWorks;
    }

    public void setArtWorks(List<ArtWorkEntity> artWorks) {
        this.artWorks = artWorks;
    }

    public Painter toPainter() {
        Painter painter = new Painter();
        BeanUtils.copyProperties(this, painter, "artWorks");
        List<ArtWork> artWorks = this.artWorks.stream()
                .map(ArtWorkEntity::toArtWork)
                .toList();
        painter.setArtWorks(artWorks);
        return painter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PainterEntity that = (PainterEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MuseumPainterEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", deathDate=" + deathDate +
                ", artWorks=" + artWorks +
                '}';
    }
}
