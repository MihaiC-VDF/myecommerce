package com.vodafone.myecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "categories")
public class CategoriesEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "categoryId", nullable = false)
    private int categoryId;
    @Basic
    @Column(name = "categoriesName")
    private String categoriesName;
    @Basic
    @Column(name = "categoriesParrent")
    private Integer categoriesParrent;

    @ManyToMany(mappedBy = "categoriesList", fetch = FetchType.LAZY)
    private Set<ProductsEntity> products = new HashSet<>();

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoriesName() {
        return categoriesName;
    }

    public void setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
    }

    public Integer getCategoriesParrent() {
        return categoriesParrent;
    }

    public void setCategoriesParrent(Integer categoriesParrent) {
        this.categoriesParrent = categoriesParrent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriesEntity that = (CategoriesEntity) o;
        return categoryId == that.categoryId && Objects.equals(categoriesName, that.categoriesName) && Objects.equals(categoriesParrent, that.categoriesParrent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoriesName, categoriesParrent);
    }
}
