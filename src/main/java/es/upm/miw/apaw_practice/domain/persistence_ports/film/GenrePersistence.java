package es.upm.miw.apaw_practice.domain.persistence_ports.film;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenrePersistence {

    void delete(String name);

    List<String> findGenreNamesByGenreStyle(String style);
}
