package com.vodafone.myecommerce.repository;

import com.vodafone.myecommerce.model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface ProductsRepository extends JpaRepository<Products, Integer>, JpaSpecificationExecutor<Products> {

    @Query("SELECT P From Products P")
    Page<Products> findAllProducts(Pageable pageable);

    Page<Products> findAll(Pageable pageable);

}