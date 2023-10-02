package es.upm.miw.apaw_practice.adapters.mongodb.zoo.entities;

import es.upm.miw.apaw_practice.domain.models.zoo.Animal;
import es.upm.miw.apaw_practice.domain.models.zoo.TaxonomicSpecie;
import es.upm.miw.apaw_practice.domain.models.zoo.Vaccine;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Document
public class AnimalEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String identificationChip;
    private String name;
    private Integer age;
    @DBRef
    private TaxonomicSpecieEntity taxonomicSpecieEntity;
    @DBRef
    private List<VaccineEntity> vaccineEntities;

    public AnimalEntity() {
        //empty for framework
    }

    public AnimalEntity(String identificationChip, String name, Integer age, TaxonomicSpecieEntity taxonomicSpecieEntity, List<VaccineEntity> vaccineEntities) {
        this.id = UUID.randomUUID().toString();
        this.identificationChip = identificationChip;
        this.name = name;
        this.age = age;
        this.taxonomicSpecieEntity = taxonomicSpecieEntity;
        this.vaccineEntities = vaccineEntities;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentificationChip() {
        return identificationChip;
    }

    public void setIdentificationChip(String identificationChip) {
        this.identificationChip = identificationChip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public TaxonomicSpecieEntity getTaxonomicSpecieEntity() {
        return taxonomicSpecieEntity;
    }

    public void setTaxonomicSpecieEntity(TaxonomicSpecieEntity taxonomicSpecieEntity) {
        this.taxonomicSpecieEntity = taxonomicSpecieEntity;
    }

    public List<VaccineEntity> getVaccineEntities() {
        return vaccineEntities;
    }

    public void setVaccineEntities(List<VaccineEntity> vaccineEntities) {
        this.vaccineEntities = vaccineEntities;
    }

    public Animal toAnimal() {
        TaxonomicSpecie taxonomicSpecie = this.taxonomicSpecieEntity.toTaxonomicSpecie();
        List<Vaccine> vaccines = this.vaccineEntities.stream()
                .map(VaccineEntity::toVaccine)
                .collect(Collectors.toList());
        return new Animal(this.identificationChip, this.name, this.age, taxonomicSpecie, vaccines);
    }

    public boolean equals(Object obj) {
        AnimalEntity objAux = (AnimalEntity) obj;
        return this == obj || obj != null && getClass() == obj.getClass() && (this.identificationChip.equals(objAux.getIdentificationChip()));
    }


    @Override
    public String toString() {
        return "AnimalEntity{" +
                "id='" + id + '\'' +
                ", identificationChip='" + identificationChip + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", taxonomicSpecieEntity=" + taxonomicSpecieEntity +
                ", vaccineEntities=" + vaccineEntities +
                '}';
    }
}
