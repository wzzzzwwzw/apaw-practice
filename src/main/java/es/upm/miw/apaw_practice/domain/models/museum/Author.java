package es.upm.miw.apaw_practice.domain.models.museum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<ArtWork> artWorks;


    public Author() { }

    public Author(String name, String surname, LocalDate birthDate, LocalDate deathDate, List<ArtWork> artWorks) {
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

    public void addArtWork(ArtWork artWork) {
        if (this.artWorks == null) {
            this.artWorks = new ArrayList<>();
        }
        this.artWorks.add(artWork);
    }
}
