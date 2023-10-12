package es.upm.miw.apaw_practice.adapters.mongodb.film.entities;

import es.upm.miw.apaw_practice.domain.models.film.Genre;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class GenreEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String description;
    private String style;

    public GenreEntity() {
    }

    public GenreEntity(Genre genre) {
        BeanUtils.copyProperties(genre, this);
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

    public Genre toGenre() {
        Genre genre = new Genre();
        BeanUtils.copyProperties(this, genre);
        return genre;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (name.equals(((GenreEntity) obj).name));
    }

    @Override
    public String toString() {
        return "GenreEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", style='" + style + '\'' +
                '}';
    }
}
