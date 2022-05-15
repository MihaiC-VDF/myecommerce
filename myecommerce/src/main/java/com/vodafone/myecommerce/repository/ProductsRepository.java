package com.vodafone.myecommerce.repository;

import com.vodafone.myecommerce.model.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity, Integer> {

//    @Query("SELECT P From ProductsEntity P")
//    Page<ProductsEntity> findAllProducts(Pageable pageable);
//
//    Page<ProductsEntity> findAll(Pageable pageable);

}