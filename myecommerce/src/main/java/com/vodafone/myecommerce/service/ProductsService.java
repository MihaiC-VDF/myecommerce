package com.vodafone.myecommerce.service;

import com.vodafone.myecommerce.customexceptions.ResourceNotFoundException;
import com.vodafone.myecommerce.model.Products;
import com.vodafone.myecommerce.pojo.PaginatedProductResponse;
import com.vodafone.myecommerce.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

    @Autowired
    private final ProductsRepository workingRepository;

    public ProductsService(ProductsRepository workingRepository) {
        this.workingRepository = workingRepository;
    }

    public void save(Products recievedProduct) {
        workingRepository.save(recievedProduct);
    }

    public void delete(Integer receivedProductId){
        workingRepository.deleteById(receivedProductId);
    }

    public ResponseEntity<Products> getById(Integer receivedId){
        Products product = workingRepository.findById(receivedId)
                .orElseThrow(() -> new ResourceNotFoundException("Product does not exist with id: " + receivedId));

        return  ResponseEntity.ok(product);
    }

    public ResponseEntity update(Integer updateProductId, Products receivedProductToUpdate){
        Products updateProduct = workingRepository.findById(updateProductId)
                        .orElseThrow(() -> new ResourceNotFoundException("Product does not exist with id: " + updateProductId));

        updateProduct.setProductName(receivedProductToUpdate.getProductName());
        updateProduct.setProductDescription(receivedProductToUpdate.getProductDescription());
        updateProduct.setProductImage(receivedProductToUpdate.getProductImage());
        updateProduct.setProductPrice(receivedProductToUpdate.getProductPrice());

        workingRepository.save(updateProduct);

        return ResponseEntity.ok(updateProduct);
    }

    public Page<Products> getProducts(Pageable pageable){
        return workingRepository.findAllProducts(pageable);
    }

    public PaginatedProductResponse products(Pageable pageable) {
        Page<Products> products = workingRepository.findAll(pageable);
        return PaginatedProductResponse.builder()
                .numberOfProducts((int)products.getTotalElements())
                .numberOfPages(products.getTotalPages())
                .retrievedProductList(products.getContent())
                .build();
    }

//    public ResponseEntity products (Pageable pageable) {
//        return     PaginatedProductResponse.builder()            .numberOfItems(prodocts.getTotalElements())
//                .numberOfPages(prodocts.getTotalPages())
//                .bookList(prodocts.getContent())
//                .build();
//    }

}
