package es.upm.miw.apaw_practice.domain.models.school;

import es.upm.miw.apaw_practice.domain.models.school.builders.SubjectBuilder;

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

    public static SubjectBuilder.Title builder() {
        return new Builder();
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

    public static class Builder implements SubjectBuilder.Title, SubjectBuilder.Description,
                                           SubjectBuilder.Bilingual, SubjectBuilder.Credits,
                                           SubjectBuilder.Build {
        private final Subject subject;

        public Builder () {
            this.subject = new Subject();
        }

        @Override
        public SubjectBuilder.Description title(String title) {
            this.subject.setTitle(title);
            return this;
        }

        @Override
        public SubjectBuilder.Bilingual description(String description) {
            this.subject.setDescription(description);
            return this;
        }

        @Override
        public SubjectBuilder.Credits bilingual(Boolean bilingual) {
            this.subject.setBilingual(bilingual);
            return this;
        }

        @Override
        public SubjectBuilder.Build credits(Integer credits) {
            this.subject.setCredits(credits);
            return this;
        }

        @Override
        public Subject build() {
            return this.subject;
        }
    }
}