package com.vodafone.myecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
}
