package com.vodafone.myecommerce.pojo;

import com.vodafone.myecommerce.model.Products;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PaginatedProductResponse {

    private List<Products> retrievedProductList;
    private int numberOfProducts;
    private int numberOfPages;


}
