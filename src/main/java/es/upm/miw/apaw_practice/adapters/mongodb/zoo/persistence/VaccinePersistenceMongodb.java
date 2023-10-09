package es.upm.miw.apaw_practice.adapters.mongodb.zoo.persistence;


import es.upm.miw.apaw_practice.adapters.mongodb.zoo.daos.VaccineRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.zoo.Vaccine;
import es.upm.miw.apaw_practice.domain.persistence_ports.zoo.VaccinePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("vaccinePersistence")
public class VaccinePersistenceMongodb implements VaccinePersistence {

    private final VaccineRepository vaccineRepository;

    @Autowired
    public VaccinePersistenceMongodb(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    public Vaccine findByIdentifierBatch(String identifierBatch) {
        return this.vaccineRepository.findByIdentifierBatch(identifierBatch)
                .orElseThrow(() -> new NotFoundException("Vaccine Identifier Batch: " + identifierBatch))
                .toVaccine()
                ;
    }

}
