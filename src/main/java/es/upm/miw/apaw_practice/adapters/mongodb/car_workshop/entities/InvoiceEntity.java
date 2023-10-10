package es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import es.upm.miw.apaw_practice.domain.models.car_workshop.CarComponent;
import es.upm.miw.apaw_practice.domain.models.car_workshop.Invoice;

@Document
public class InvoiceEntity {
    @Id
    private String id;
    private LocalDateTime invoiceDate;
    private BigDecimal totalPrice;
    private Boolean paid;
    @DBRef
    private CarToRepairEntity carToRepairEntity;
    @DBRef
    private List<CarComponentEntity> carComponentEntities;

    public InvoiceEntity() {
        // empty for framework
    }

    public InvoiceEntity(LocalDateTime invoiceDate, BigDecimal totalPrice, Boolean paid,
            CarToRepairEntity carToRepairEntity,
            List<CarComponentEntity> carComponentEntities) {
        this.id = UUID.randomUUID().toString();
        this.invoiceDate = invoiceDate;
        this.totalPrice = totalPrice;
        this.paid = paid;
        this.carToRepairEntity = carToRepairEntity;
        this.carComponentEntities = carComponentEntities;
    }

    public InvoiceEntity(Invoice invoice) {
        BeanUtils.copyProperties(invoice, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public CarToRepairEntity getCarToRepairEntity() {
        return carToRepairEntity;
    }

    public void setCarToRepairEntity(CarToRepairEntity carToRepairEntity) {
        this.carToRepairEntity = carToRepairEntity;
    }

    public List<CarComponentEntity> getCarComponentEntities() {
        return carComponentEntities;
    }

    public void setCarComponentEntities(List<CarComponentEntity> carComponentEntities) {
        this.carComponentEntities = carComponentEntities;
    }

    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Invoice toInvoice() {
        List<CarComponent> carComponents = this.carComponentEntities.stream()
                .map(CarComponentEntity::toCarComponent)
                .toList();
        return new Invoice(this.invoiceDate, this.totalPrice, this.paid, carComponents,
                this.carToRepairEntity.toCarToRepair());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InvoiceEntity other = (InvoiceEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "InvoiceEntity [id=" + id + ", invoiceDate=" + invoiceDate + ", totalPrice=" + totalPrice + ", paid="
                + paid + ", carToRepairEntity=" + carToRepairEntity + ", carComponentEntities=" + carComponentEntities
                + "]";
    }

}
