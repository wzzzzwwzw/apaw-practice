package es.upm.miw.apaw_practice.domain.services.zoo;

import es.upm.miw.apaw_practice.domain.models.zoo.Vaccine;
import es.upm.miw.apaw_practice.domain.persistence_ports.zoo.VaccinePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccineService {
    private final VaccinePersistence vaccinePersistence;

    @Autowired
    public VaccineService(VaccinePersistence vaccinePersistence) {
        this.vaccinePersistence = vaccinePersistence;
    }

    public Vaccine findByIdentifierBatch(String identifierBatch) {
        return this.vaccinePersistence.findByIdentifierBatch(identifierBatch);
    }
}
