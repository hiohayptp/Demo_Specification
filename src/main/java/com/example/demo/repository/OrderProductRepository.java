package com.example.demo.repository;

import com.example.demo.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct,Integer>, JpaSpecificationExecutor<OrderProduct> {

    List<OrderProduct> findAllByProductId(Integer id);
}
