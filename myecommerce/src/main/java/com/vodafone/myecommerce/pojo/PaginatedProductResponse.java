package com.vodafone.myecommerce.pojo;

import com.vodafone.myecommerce.model.ProductsEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PaginatedProductResponse {

    private List<ProductsEntity> retrievedProductList;
    private int numberOfProducts;
    private int numberOfPages;


}
