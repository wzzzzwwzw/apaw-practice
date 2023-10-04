package es.upm.miw.apaw_practice.domain.models.bakery;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Ticket {
    private LocalDateTime createdAt;
    private BigDecimal totalPrice;
    private int totalProducts;
    private List<Product> products;

    public Ticket() {
        //empty for framework
    }

    public Ticket(LocalDateTime createdAt, BigDecimal totalPrice, int totalProducts, List<Product> products) {
        this.createdAt = createdAt;
        this.totalPrice = totalPrice;
        this.totalProducts = totalProducts;
        this.products = products;
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

    public int getTotalProducts() {
        return this.totalProducts;
    }

    public void setTotalProducts(int totalProducts) {
        this.totalProducts = totalProducts;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "{" +
            " createdAt='" + getCreatedAt() + "'" +
            ", totalPrice='" + getTotalPrice() + "'" +
            ", totalProducts='" + getTotalProducts() + "'" +
            ", products='" + getProducts() + "'" +
            "}";
    }
}
