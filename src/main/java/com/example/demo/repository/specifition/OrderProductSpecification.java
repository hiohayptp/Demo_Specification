package com.example.demo.repository.specifition;

import com.example.demo.entity.OrderProduct;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class OrderProductSpecification implements Specification {
    @Override
    public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
        return null;
    }

    @Override
    public Specification and(Specification other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification or(Specification other) {
        return Specification.super.or(other);
    }

//    public static Specification<OrderProduct> findByUserIdAndProductNameLike(Integer userId, String productName){
//        return (root, query, criteriaBuilder) ->{
//            Join<User, OrderProduct> oderUser = root.join("user_id");
//            Join<Product, OrderProduct> oderProduct = root.join("product_id");
//            Join<oderUser, oderProduct> join = root.join("product_id");
//
//        };
//    }
    public static Specification<OrderProduct> hasByUserId(Integer userId){
        return (root, query, criteriaBuilder) -> {
            Join<User, OrderProduct> oderUser = root.join("user_id");
            return criteriaBuilder.equal(oderUser.get("user_id"), userId);
        };
    }
    public static Specification<OrderProduct> hasByProductName(String productName){
        return (root, query, criteriaBuilder) -> {
            Join<Product, OrderProduct> oderProduct = root.join("product_id");
            return criteriaBuilder.like(oderProduct.<String>get("product_name"),"%" + productName + "%");
        };
    }

    public static Specification<OrderProduct> findByUserIdAndProductName(Integer userId, String productName){
        Specification<OrderProduct> opSpe = hasByUserId(userId).and(hasByProductName(productName));
        return opSpe;
    }

    public static Specification<OrderProduct> findByProduct(Integer productId){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("product_id"),productId);
    }

    public static Specification<OrderProduct> findByUserId(Integer userId){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("user_id"),userId);
    }

    public static Specification<OrderProduct> findByProductId(Integer productId){
        return new Specification<OrderProduct>() {
            @Override
            public Predicate toPredicate(Root root,
                                         CriteriaQuery query,
                                         CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("productId"),productId));
                return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
            }
        };
    }
}
