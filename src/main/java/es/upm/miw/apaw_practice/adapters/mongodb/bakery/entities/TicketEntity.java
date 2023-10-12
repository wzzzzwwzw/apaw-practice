package es.upm.miw.apaw_practice.adapters.mongodb.bakery.entities;

import es.upm.miw.apaw_practice.domain.models.bakery.Ticket;
import es.upm.miw.apaw_practice.domain.models.bakery.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Document
public class TicketEntity {
    @Id
    private String id;
    private LocalDateTime createdAt;
    private BigDecimal totalPrice;
    private Integer totalProducts;
    private List<Product> products;

    public TicketEntity() {
        //empty for framework
    }

    public TicketEntity(Ticket ticket) {
        BeanUtils.copyProperties(ticket, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalProducts() {
        return this.totalProducts;
    }

    public void setTotalProducts(Integer totalProducts) {
        this.totalProducts = totalProducts;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((TicketEntity) obj).id));
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", totalPrice='" + getTotalPrice() + "'" +
            ", totalProducts='" + getTotalProducts() + "'" +
            ", products='" + getProducts() + "'" +
            "}";
    }
}
