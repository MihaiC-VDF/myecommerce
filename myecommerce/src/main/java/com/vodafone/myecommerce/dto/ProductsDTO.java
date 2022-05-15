package com.vodafone.myecommerce.dto;

import com.vodafone.myecommerce.model.ProductsEntity;

public class ProductsDTO {
    private ProductsEntity productsEntity;

    public ProductsDTO(ProductsEntity productsEntity) {
        this.productsEntity = productsEntity;
    }
}
