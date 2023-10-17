package es.upm.miw.apaw_practice.domain.models.museum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Painter implements PainterComponent {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<ArtWork> artWorks;

    public Painter() { }

    public Painter(String name, String surname, LocalDate birthDate, LocalDate deathDate, List<ArtWork> artWorks) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.artWorks = artWorks;
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

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public void add(PainterComponent painterComponent) {
        // Do nothing because it is a leaf
    }

    @Override
    public void remove(PainterComponent painterComponent) {
        // Do nothing because it is a leaf
    }
}
