package es.upm.miw.apaw_practice.adapters.mongodb.zoo.entities;

import es.upm.miw.apaw_practice.domain.models.zoo.TaxonomicSpecie;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class TaxonomicSpecieEntity {


    @Id
    private String id;
    private String genusName;
    @Indexed(unique = true)
    private String speciesName;
    private Boolean inDangerOfExtinction;
    private String habitat;

    public TaxonomicSpecieEntity() {
        //empty for framework
    }

    public TaxonomicSpecieEntity(TaxonomicSpecie taxonomicSpecie) {
        BeanUtils.copyProperties(taxonomicSpecie, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getGenusName() {
        return genusName;
    }

    public void setGenusName(String genusName) {
        this.genusName = genusName;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public Boolean getInDangerOfExtinction() {
        return inDangerOfExtinction;
    }

    public void setInDangerOfExtinction(Boolean inDangerOfExtinction) {
        this.inDangerOfExtinction = inDangerOfExtinction;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public TaxonomicSpecie toTaxonomicSpecie() {
        TaxonomicSpecie taxonomicSpecie = new TaxonomicSpecie();
        BeanUtils.copyProperties(this, taxonomicSpecie);
        return taxonomicSpecie;
    }

    @Override
    public boolean equals(Object obj) {
        TaxonomicSpecieEntity objAux = (TaxonomicSpecieEntity) obj;
        return this == obj || obj != null && getClass() == obj.getClass() && (this.speciesName.equals(objAux.getSpeciesName()));
    }

    @Override
    public String toString() {
        return "TaxonomicSpecieEntity{" +
                "id='" + id + '\'' +
                ", genusName='" + genusName + '\'' +
                ", speciesName='" + speciesName + '\'' +
                ", inDangerOfExtinction=" + inDangerOfExtinction +
                ", habitat='" + habitat + '\'' +
                '}';
    }
}
