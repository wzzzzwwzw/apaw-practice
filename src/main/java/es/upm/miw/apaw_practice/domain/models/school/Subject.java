package es.upm.miw.apaw_practice.domain.models.school;

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

    public Boolean isBilingual() {
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
    public String toString() {
        return "Subject{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", bilingual=" + bilingual +
                ", credits=" + credits +
                '}';
    }
}
