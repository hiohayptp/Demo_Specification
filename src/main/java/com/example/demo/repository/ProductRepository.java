package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

    List<Product> findByShopTitle (String title);
    List<Product> findByProductNameLikeOrderByProductNameAsc (String name);
    List<Product> findByProductNameLike (String name);
    List<Product> findByShopTitleOrderByShopTitleAsc (String title);
}
