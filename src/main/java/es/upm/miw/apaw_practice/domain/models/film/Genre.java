package es.upm.miw.apaw_practice.domain.models.film;

public class Genre {

    private String name;
    private String description;
    private String style;

    public Genre() {
    }

    public Genre(String name, String description, String style) {
        this.name = name;
        this.description = description;
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
