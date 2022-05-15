package com.vodafone.myecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "products")
public class ProductsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "productId", nullable = false)
    private Integer productId;


    @Column(name = "productUuid", nullable = false)
    private String productUuid;

    @Column(name = "productName", nullable = false)
    private String productName;

    @Column(name = "productDescription")
    private String productDescription;

    @Column(name = "productImage")
    private String productImage;

    @Column(name = "productPrice")
    private Double productPrice;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "products_categories",
                joinColumns = {
                    @JoinColumn (name ="productUuid", referencedColumnName = "productUuid",
                    nullable = false, updatable = false)},
                inverseJoinColumns = {
                    @JoinColumn (name = "categoryId", referencedColumnName = "categoryId",
                    nullable = false, updatable = false)})
    private Set<CategoriesEntity> categoriesList = new HashSet<>();

    public ProductsEntity(String productName, String productDescription, String productImage, Double productPrice) {
        this.productUuid = UUID.randomUUID().toString();
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.productPrice = productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductsEntity that = (ProductsEntity) o;
            return productId != null && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
