package es.upm.miw.apaw_practice.domain.services.fruitshop;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.fruitShop.FruitSpecie;
import es.upm.miw.apaw_practice.domain.persistence_ports.fruitshop.FruitSpeciePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FruitSpecieService {
    private final FruitSpeciePersistence fruitSpeciePersistence;

    @Autowired
    public FruitSpecieService(FruitSpeciePersistence fruitSpeciePersistence){
        this.fruitSpeciePersistence = fruitSpeciePersistence;
    }

    public FruitSpecie create(FruitSpecie fruitSpecie) {
        this.assertSpeciesNotExist(fruitSpecie.getSpecie());
        return this.fruitSpeciePersistence.create(fruitSpecie);
    }

    public void assertSpeciesNotExist(String specie){
        if (this.fruitSpeciePersistence.existSpecie(specie))
        {
            throw new ConflictException("FruitSpecie already exists:" + specie);
        }
    }
}
