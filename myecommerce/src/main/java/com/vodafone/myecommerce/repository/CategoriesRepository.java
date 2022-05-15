package com.vodafone.myecommerce.repository;

import com.vodafone.myecommerce.model.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesEntity, Integer> {
}
