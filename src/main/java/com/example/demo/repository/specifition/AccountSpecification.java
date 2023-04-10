package com.example.demo.repository.specifition;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AccountSpecification implements Specification {
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


}
