package com.example.demo.repository.specifition;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductSpecification implements Specification {
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

    public static Specification<Product> findOrder(Integer userId){
        return new Specification<Product>(){
            @Override
            public Predicate toPredicate(Root root,
                                         CriteriaQuery query,
                                         CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("orderProducts").get("user_id"), userId));
                return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
            }
        };
    }

    public static Specification<Product> search(String keySearch){
        return new Specification<Product>(){
            @Override
            public Predicate toPredicate(Root root,
                                         CriteriaQuery query,
                                         CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (Objects.nonNull(keySearch)){
                     predicates.add(criteriaBuilder.or(criteriaBuilder.like(root.get("shop").get("title"), "%" + keySearch + "%")
                            , criteriaBuilder.like(root.get("productName"), "%" + keySearch + "%")
                            ,criteriaBuilder.like(root.get("shop").get("address"), "%" + keySearch + "%")));

                }
                return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
            }
        };
    }
}
