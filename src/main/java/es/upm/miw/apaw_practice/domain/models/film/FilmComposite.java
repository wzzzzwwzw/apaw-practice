package es.upm.miw.apaw_practice.domain.models.film;

import java.util.ArrayList;
import java.util.List;

public class FilmComposite implements TreeFilm {

    private final String filmTitle;
    private final List<TreeFilm> treeFilms;

    public FilmComposite(String filmTitle) {
        this.filmTitle = filmTitle;
        this.treeFilms = new ArrayList<>();
    }

    @Override
    public void add(TreeFilm treeFilm) {
        this.treeFilms.add(treeFilm);
    }

    @Override
    public void remove(TreeFilm treeFilm) {
        this.treeFilms.remove(treeFilm);
    }

    @Override
    public String toString() {
        return "FilmComposite{" +
                "filmTitle='" + filmTitle + '\'' +
                ", treeFilms=" + treeFilms +
                '}';
    }
}
