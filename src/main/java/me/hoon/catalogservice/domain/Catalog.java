package me.hoon.catalogservice.domain;

import lombok.Builder;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Entity
@SequenceGenerator(name = "CATALOG_SEQUENCE_GENERATOR",
sequenceName = "CATALOG_SEQUENCE",
initialValue = 1, allocationSize = 50)
public class Catalog {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATALOG_SEQUENCE_GENERATOR")
    private Long id;

    @Column(nullable = false, length = 120, unique = true)
    private String productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Integer unitPrice;

    @Column(nullable = false, updatable = false, insertable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Date createAt;

    public Catalog() {

    }

    @Builder
    public Catalog(String productId, String productName, Integer stock, Integer unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.stock = stock;
        this.unitPrice = unitPrice;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getStock() {
        return stock;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public Date getCreateAt() {
        return createAt;
    }
}
