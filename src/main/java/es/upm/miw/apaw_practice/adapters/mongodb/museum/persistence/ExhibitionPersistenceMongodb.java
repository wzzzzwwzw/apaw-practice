package es.upm.miw.apaw_practice.adapters.mongodb.museum.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.daos.ExhibitionRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.ExhibitionPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("exhibitionPersistence")
public class ExhibitionPersistenceMongodb implements ExhibitionPersistence {

    private final ExhibitionRepository exhibitionRepository;

    @Autowired
    public ExhibitionPersistenceMongodb(ExhibitionRepository exhibitionRepository) {
        this.exhibitionRepository = exhibitionRepository;
    }

    @Override
    public void delete(String exhibitionName) {
        this.exhibitionRepository.deleteById(exhibitionName);
    }
}
