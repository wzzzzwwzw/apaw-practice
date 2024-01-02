package es.upm.miw.apaw_practice.adapters.mongodb.bank.entities;

import es.upm.miw.apaw_practice.domain.models.bank.BankType;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Document
public class BankTypeEntity {


    @Id
    private String id;
    @Indexed(unique = true)
    private String typeName;

    private String description;

    private BigDecimal minimunCapital;


    public BankTypeEntity(){

    }

    public BankTypeEntity(String typeName,String description,BigDecimal minimunCapital){
        this.id=UUID.randomUUID().toString();
        this.typeName=typeName;
        this.description=description;
        this.minimunCapital=minimunCapital;
    }

    public String getId() {
        return this.id;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public String getDescription() {
        return this.description;
    }

    public BigDecimal getMinimunCapital() {
        return this.minimunCapital;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMinimunCapital(BigDecimal minimunCapital) {
        this.minimunCapital = minimunCapital;
    }

    public BankType toBankType(){
        BankType bankType=new BankType();
        BeanUtils.copyProperties(this,bankType);
        return bankType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankTypeEntity that = (BankTypeEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(typeName, that.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeName);
    }

    @Override
    public String toString() {
        return "BankTypeEntity{" +
                "id='" + this.id + '\'' +
                ", typeName='" + this.typeName + '\'' +
                ", description='" + this.description + '\'' +
                ", minimunCapital=" + this.minimunCapital +
                '}';
    }
}
