package es.upm.miw.apaw_practice.domain.services.olympic_games;

import es.upm.miw.apaw_practice.domain.persistence_ports.olympic_games.DisciplinePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplineService {

    private final DisciplinePersistence disciplinePersistence;

    @Autowired
    public DisciplineService(DisciplinePersistence disciplinePersistence) {
        this.disciplinePersistence = disciplinePersistence;
    }

    public void delete(String name) {
        this.disciplinePersistence.delete(name);
    }
}
