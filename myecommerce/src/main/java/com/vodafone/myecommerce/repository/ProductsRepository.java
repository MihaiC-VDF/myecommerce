package com.vodafone.myecommerce.repository;

import com.vodafone.myecommerce.model.ProductsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface ProductsRepository extends JpaRepository<ProductsEntity, Integer>, JpaSpecificationExecutor<ProductsEntity> {

    @Query("SELECT P From ProductsEntity P")
    Page<ProductsEntity> findAllProducts(Pageable pageable);

    Page<ProductsEntity> findAll(Pageable pageable);

}