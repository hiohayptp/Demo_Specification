package com.example.demo.service.Impl;

import com.example.demo.dto.OrderProductDTO;
import com.example.demo.entity.OrderProduct;
import com.example.demo.mapper.OrderProductMapper;
import com.example.demo.repository.OrderProductRepository;
import com.example.demo.repository.specifition.OrderProductSpecification;
import com.example.demo.service.IOrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductServiceImpl implements IOrderProductService {
    @Autowired
    OrderProductRepository repository;
    @Autowired
    OrderProductMapper mapper;

    public List<OrderProduct> findByUserIdAndProductName(Integer userId, String productName){
        List<OrderProduct> orderProducts= repository.findAll(OrderProductSpecification.findByUserIdAndProductName(userId,productName));
        return orderProducts;
    }

    public List<OrderProductDTO> findByProductId(Integer productId){
//        List<OrderProduct> orderProducts= repository.findAll(OrderProductSpecification.findByProductId(productId));
        List<OrderProduct> orderProducts= repository.findAllByProductId(productId);
        return mapper.listOrderProductToOrderProductDto(orderProducts);
    }

    public List<OrderProduct> findByUserId(Integer userId){
        List<OrderProduct> orderProducts= repository.findAll(OrderProductSpecification.findByUserId(userId));
        return orderProducts;
    }
}
