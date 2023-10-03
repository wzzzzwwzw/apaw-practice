package es.upm.miw.apaw_practice.domain.models.car_workshop;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private LocalDateTime invoiceDate;
    private BigDecimal totalPrice;
    private Boolean paid;
    private List<CarComponent> carComponents;

    public Invoice() {
        this.carComponents = new ArrayList<CarComponent>();
    }

    public Invoice(LocalDateTime invoiceDate, BigDecimal totalPrice, Boolean paid) {
        this.invoiceDate = invoiceDate;
        this.totalPrice = totalPrice;
        this.paid = paid;
        this.carComponents = new ArrayList<CarComponent>();
    }

    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public BigDecimal gettotalPrice() {
        return totalPrice;
    }

    public void settotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public List<CarComponent> getCarComponents() {
        return carComponents;
    }

    public void setCarComponents(List<CarComponent> carComponents) {
        this.carComponents = carComponents;
    }
}
