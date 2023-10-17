package es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.daos.DisciplineRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.olympic_games.DisciplinePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("disciplinePersistence")
public class DisciplinePersistenceMongodb implements DisciplinePersistence {

    private final DisciplineRepository disciplineRepository;

    @Autowired
    public DisciplinePersistenceMongodb(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    @Override
    public void delete(String name) {
        this.disciplineRepository.deleteByName(name);
    }
}
