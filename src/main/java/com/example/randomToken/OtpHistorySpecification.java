package com.example.randomToken;


import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class OtpHistorySpecification implements Specification<OtpHistory> {

    private Specification<OtpHistory> specification;

    @Override
    public Specification<OtpHistory> and(Specification<OtpHistory> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<OtpHistory> or(Specification<OtpHistory> other) {
        return Specification.super.or(other);
    }

    @Override
    public Predicate toPredicate(Root<OtpHistory> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (specification != null) {
            return criteriaBuilder.and(specification.toPredicate(root, query, criteriaBuilder));
        }
        return null;
    }

    public static Specification<OtpHistory> findByPhoneNumberOrTransactionId(String phoneNumber, OtpTypeEnum type) {
        return ((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.isNotEmpty(phoneNumber)) predicates.add(builder.equal(root.get("phoneNumber"), phoneNumber));
            if (ObjectUtils.isNotEmpty(type)) predicates.add(builder.equal(root.get("type"), type));
            return builder.and(predicates.toArray(Predicate[]::new));
        });
    }

}
