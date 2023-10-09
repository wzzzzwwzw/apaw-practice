package es.upm.miw.apaw_practice.adapters.mongodb.zoo;

import es.upm.miw.apaw_practice.adapters.mongodb.zoo.daos.AnimalRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.daos.TaxonomicSpecieRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.daos.VaccineRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.daos.ZooRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.entities.AnimalEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.entities.TaxonomicSpecieEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.entities.VaccineEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.zoo.entities.ZooEntity;
import es.upm.miw.apaw_practice.domain.models.zoo.TaxonomicSpecie;
import es.upm.miw.apaw_practice.domain.models.zoo.Vaccine;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

@Service
public class ZooSeederService {

    @Autowired
    private TaxonomicSpecieRepository taxonomicSpecieRepository;
    @Autowired
    private VaccineRepository vaccineRepository;
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private ZooRepository zooRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Zoo Initial Load -----------");
        TaxonomicSpecieEntity[] taxonomicSpecies = {
                new TaxonomicSpecieEntity(new TaxonomicSpecie("Canis", "familiaris", false, "human houses")),
                new TaxonomicSpecieEntity(new TaxonomicSpecie("Canis", "lupus", false, "forests, inland wetlands, shrublands, grasslands, pastures, deserts, rocky peaks ")),
                new TaxonomicSpecieEntity(new TaxonomicSpecie("Felis", "catus", false, "human houses")),
                new TaxonomicSpecieEntity(new TaxonomicSpecie("Felis", "nigripes", true, "human houses")),
                new TaxonomicSpecieEntity(new TaxonomicSpecie("Lynx", "pardinus", true, "Iberian Peninsula Mediterranean to Galicia")),
                new TaxonomicSpecieEntity(new TaxonomicSpecie("Lynx", "canadensis", false, "boreal forest of Canada"))
        };
        this.taxonomicSpecieRepository.saveAll(Arrays.asList(taxonomicSpecies));
        VaccineEntity[] vaccines = {
                new VaccineEntity(new Vaccine("202301A-FLU-CANIS", "Canis Flu 2023", LocalDate.of(2023, 1, 20))),
                new VaccineEntity(new Vaccine("202301B-FLU-CANIS", "Canis Flu 2023", LocalDate.of(2023, 2, 20))),
                new VaccineEntity(new Vaccine("202302A-FLU-CANIS", "Canis Flu 2023", LocalDate.of(2023, 2, 3))),
                new VaccineEntity(new Vaccine("202301A-FLU-FELIS", "Felis Flu 2023", LocalDate.of(2023, 1, 20))),
                new VaccineEntity(new Vaccine("202301B-FLU-FELIS", "Felis Flu 2023", LocalDate.of(2023, 1, 5))),
                new VaccineEntity(new Vaccine("202202A-FLU-FELIS", "Felis Flu 2022", LocalDate.of(2022, 2, 8))),
                new VaccineEntity(new Vaccine("202302C-FLU-FELIS", "Felis Flu 2022 Special", LocalDate.of(2022, 9, 7))),
                new VaccineEntity(new Vaccine("202002C-FLU-FELINAE", "Felinae General 2020", LocalDate.of(2020, 7, 9)))

        };
        this.vaccineRepository.saveAll(Arrays.asList(vaccines));

        AnimalEntity[] animals = {
                new AnimalEntity("001DOG", "KIRA", 2, taxonomicSpecies[0], Collections.singletonList(vaccines[0])),
                new AnimalEntity("005DOG", "WASON", 5, taxonomicSpecies[0], Arrays.asList(vaccines[0], vaccines[1])),
                new AnimalEntity("005WOLF", "GOSH", 8, taxonomicSpecies[1], Arrays.asList(vaccines[2], vaccines[1])),
                new AnimalEntity("009WOLF", "WILD", 4, taxonomicSpecies[1], Arrays.asList(vaccines[0], vaccines[1], vaccines[2])),
                new AnimalEntity("001CAT", "BOLA", 6, taxonomicSpecies[2], Arrays.asList(vaccines[6], vaccines[7])),
                new AnimalEntity("020CAT", "SOMBRA", 5, taxonomicSpecies[3], Arrays.asList(vaccines[3], vaccines[6])),
                new AnimalEntity("080CAT", "SNOWBALL V", 6, taxonomicSpecies[3], Arrays.asList(vaccines[4], vaccines[7], vaccines[3])),
                new AnimalEntity("074LYNX", "SNOWBALL V", 30, taxonomicSpecies[4], Arrays.asList(vaccines[3], vaccines[7])),
                new AnimalEntity("050LYNX", "SNOWBALL IV", 5, taxonomicSpecies[4], Arrays.asList(vaccines[7], vaccines[5])),
                new AnimalEntity("065LYNX", "SNOWBALL III", 38, taxonomicSpecies[5], Arrays.asList(vaccines[7], vaccines[4])),
                new AnimalEntity("081LYNX", "SNOWBALL V", 7, taxonomicSpecies[5], Collections.singletonList(vaccines[7]))
        };
        this.animalRepository.saveAll(Arrays.asList(animals));

        ZooEntity[] zoos = {
                new ZooEntity("PROTECTORA CANINA", "GETAFE", new BigDecimal("7.5"), Collections.singletonList(animals[0])),
                new ZooEntity("ZOO MADRID", "MADRID", new BigDecimal("10"), Arrays.asList(animals[1], animals[2], animals[3], animals[4], animals[5])),
                new ZooEntity("FAUNIA", "MADRID", new BigDecimal("20"), Arrays.asList(animals[6], animals[7], animals[8], animals[9], animals[10]))
        };
        this.zooRepository.saveAll(Arrays.asList(zoos));
    }

    public void deleteAll() {
        this.zooRepository.deleteAll();
        this.animalRepository.deleteAll();
        this.vaccineRepository.deleteAll();
        this.taxonomicSpecieRepository.deleteAll();
    }
}
