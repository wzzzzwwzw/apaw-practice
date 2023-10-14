package es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.daos.FruitSpecieRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities.FruitSpecieEntity;
import es.upm.miw.apaw_practice.domain.models.fruitShop.FruitSpecie;
import es.upm.miw.apaw_practice.domain.persistence_ports.fruitshop.FruitSpeciePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("fruitSpeciePersistence")
public class FruitSpeciePersistenceMongdb implements FruitSpeciePersistence {
    private final FruitSpecieRepository fruitSpecieRepository;

    @Autowired
    public FruitSpeciePersistenceMongdb(FruitSpecieRepository fruitSpecieRepository){
        this.fruitSpecieRepository = fruitSpecieRepository;
    }

    @Override
    public FruitSpecie create(FruitSpecie fruitSpecie){
        return this.fruitSpecieRepository.save(new FruitSpecieEntity(fruitSpecie))
                .toFruitSpecie();
    }

    @Override
    public boolean existSpecie(String specie) {
        return this.fruitSpecieRepository
                .findBySpecie(specie)
                .isPresent();
    }

}
