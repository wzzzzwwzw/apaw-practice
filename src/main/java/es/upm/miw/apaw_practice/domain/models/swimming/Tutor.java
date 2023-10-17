package es.upm.miw.apaw_practice.domain.models.swimming;

public class Tutor {
    private String appellation;
    private String specialty;
    private Integer experience;
    private Lesson lesson;

    public Tutor() {
        //empty for framework
    }

    public Tutor(String appellation, String specialty, Integer experience, Lesson lesson) {
        this.appellation = appellation;
        this.specialty = specialty;
        this.experience = experience;
        this.lesson = lesson;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "appellation='" + appellation + '\'' +
                ", specialty='" + specialty + '\'' +
                ", experience=" + experience + '\'' +
                ", lesson=" + lesson +
                '}';
    }
}
