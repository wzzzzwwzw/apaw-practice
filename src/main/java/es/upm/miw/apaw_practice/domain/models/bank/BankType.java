package es.upm.miw.apaw_practice.domain.models.bank;

import java.math.BigDecimal;

public class BankType {
    private String typeName;
    private String description;
    private BigDecimal minimunCapital;

    public BankType(){
        //empty for framework
    }
    public BankType(String typeName,String description,BigDecimal minimumCapital){
        this.typeName=typeName;
        this.description=description;
        this.minimunCapital=minimumCapital;
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

    @Override
    public String toString() {
        return "BankType{" +
                "typeName='" + this.typeName + '\'' +
                ", description='" + this.description + '\'' +
                ", minimunCapital=" + this.minimunCapital +
                '}';
    }
}

