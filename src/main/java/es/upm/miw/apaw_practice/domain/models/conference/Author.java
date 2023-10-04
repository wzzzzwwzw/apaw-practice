package es.upm.miw.apaw_practice.domain.models.conference;

public class Author {
    private String name;
    private String surname;
    private String honorific;

    public Author() {
        //empty for framework
    }

    public Author(String name, String surname, String honorific) {
        this.name = name;
        this.surname = surname;
        this.honorific = honorific;
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

    public String getHonorific() {
        return honorific;
    }

    public void setHonorific(String honorific) {
        this.honorific = honorific;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", honorific='" + honorific + '\'' +
                '}';
    }
}
