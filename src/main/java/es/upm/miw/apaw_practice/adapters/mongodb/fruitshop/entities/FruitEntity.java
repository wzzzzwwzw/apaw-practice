package es.upm.miw.apaw_practice.adapters.mongodb.fruitshop.entities;

import es.upm.miw.apaw_practice.domain.models.fruitShop.Fruit;
import es.upm.miw.apaw_practice.domain.models.fruitShop.FruitSpecie;
import es.upm.miw.apaw_practice.domain.models.fruitShop.Customer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.Collectors;

@Document
public class FruitEntity {

    @Id
    private String id;

    @Indexed(unique = true)
    private String type;
    private BigDecimal unitPrice;
    private Boolean tropical;
    private LocalDate stockTime;
    @DBRef
    private FruitSpecieEntity fruitSpecieEntity;
    @DBRef
    private List<CustomerEntity> customerEntities;

    public FruitEntity() {
        //empty for framework
    }

    public FruitEntity(String id, String type, BigDecimal unitPrice, Boolean tropical, LocalDate stockTime, FruitSpecieEntity fruitSpecieEntity, List<CustomerEntity> customerEntities) {
        this.id = id;
        this.type = type;
        this.unitPrice = unitPrice;
        this.tropical = tropical;
        this.stockTime = stockTime;
        this.fruitSpecieEntity = fruitSpecieEntity;
        this.customerEntities = customerEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Boolean isTropical() {
        return tropical;
    }

    public void setTropical(Boolean tropical) {
        this.tropical = tropical;
    }

    public LocalDate getStockTime() {
        return stockTime;
    }

    public void setStockTime(LocalDate stockTime) {
        this.stockTime = stockTime;
    }

    public FruitSpecieEntity getFruitSpecieEntity() {
        return fruitSpecieEntity;
    }

    public void setFruitSpecieEntity(FruitSpecieEntity fruitSpecieEntity) {
        this.fruitSpecieEntity = fruitSpecieEntity;
    }

    public List<CustomerEntity> getCustomerEntities() {
        return customerEntities;
    }

    public void setCustomerEntities(List<CustomerEntity> customerEntities) {
        this.customerEntities = customerEntities;
    }

    public Fruit toFruit() {
        FruitSpecie fruitSpecie = this.fruitSpecieEntity.toFruitSpecie();
        List<Customer> customers = this.customerEntities.stream()
                .map(CustomerEntity::toCustomer)
                .collect(Collectors.toList());
        return new Fruit(this.type, this.unitPrice, this.tropical, this.stockTime, fruitSpecie, customers);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    public boolean equals(Object obj) {
        FruitEntity objAux = (FruitEntity) obj;
        return this == obj || obj != null && getClass() == obj.getClass() && (this.type.equals(objAux.getType()));
    }

    @Override
    public String toString() {
        return "FruitEntity{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", unitPrice=" + unitPrice +
                ", tropical=" + tropical +
                ", stockTime=" + stockTime +
                ", fruitSpecieEntity=" + fruitSpecieEntity +
                ", customerEntities=" + customerEntities +
                '}';
    }
}
