package es.upm.miw.apaw_practice.domain.models.school;

import java.util.Objects;

public class Subject {
    private String title;
    private String description;
    private Boolean bilingual;
    private Integer credits;

    public Subject () {
        //empty for framework
    }

    public Subject (String title, String description, Boolean bilingual, Integer credits) {
        this.title = title;
        this.description = description;
        this.bilingual = bilingual;
        this.credits = credits;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getBilingual() {
        return this.bilingual;
    }

    public void setBilingual(Boolean bilingual) {
        this.bilingual = bilingual;
    }

    public Integer getCredits() {
        return this.credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject subject)) return false;
        return Objects.equals(title, subject.title) && Objects.equals(description, subject.description) && Objects.equals(bilingual, subject.bilingual) && Objects.equals(credits, subject.credits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, bilingual, credits);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", bilingual=" + bilingual +
                ", credits=" + credits +
                '}';
    }
}
