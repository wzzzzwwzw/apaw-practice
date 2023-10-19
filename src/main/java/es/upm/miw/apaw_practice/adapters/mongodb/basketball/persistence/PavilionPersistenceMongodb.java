package es.upm.miw.apaw_practice.adapters.mongodb.basketball.persistence;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos.PavilionRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.PavilionEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.basketball.Pavilion;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.PavilionPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("pavilionPersistence")
public class PavilionPersistenceMongodb implements PavilionPersistence {
    private final PavilionRepository pavilionRepository;

    @Autowired
    public PavilionPersistenceMongodb(PavilionRepository pavilionRepository) {
        this.pavilionRepository = pavilionRepository;
    }

    @Override
    public Pavilion readByPavname(String pavname) {
        return this.pavilionRepository.findByPavname(pavname)
                .orElseThrow(() -> new NotFoundException("Pavilion name: " + pavname))
                .toPavilion();
    }

    @Override
    public Pavilion create(Pavilion pavilion) {
        return this.pavilionRepository
                .save(new PavilionEntity(pavilion))
                .toPavilion();
    }

}
