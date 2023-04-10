package com.example.demo.repository.specifition;

import com.example.demo.entity.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class UserSpecification implements Specification {
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

    public static Specification<User> findUserByName(String name){
        return new Specification<User>(){
            @Override
            public Predicate toPredicate(Root root,
                                         CriteriaQuery query,
                                         CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.like(root.get("name"),"%" + name + "%"));
                return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
            }
        };
    }
    public static Specification<User> findByNameLike(String name){
        return new Specification<User>(){
            @Override
            public Predicate toPredicate(Root root,
                                         CriteriaQuery query,
                                         CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.like(root.get("name"),"%" + name + "%"));
                return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
            }
        };
    }
    public static Specification<User> findByIdAndName( Integer id, String name){
        return new Specification<User>(){
            @Override
            public Predicate toPredicate(Root root,
                                         CriteriaQuery query,
                                         CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("id"),id));
                predicates.add(criteriaBuilder.like(root.get("name") , "%" + name + "%"));
                return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
            }
        };
    }
    public static Specification<User> findByNameLikeAndAge(String name, Integer age){
        return new Specification<User>(){
            @Override
            public Predicate toPredicate(Root root,
                                         CriteriaQuery query,
                                         CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.like(root.get("name"),"%" + name + "%"));
                predicates.add(criteriaBuilder.equal(root.get("age") , age));
                return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
            }
        };
    }
    public static Specification<User> findUserById(Integer userId){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.join("orderProducts").get("user_id"), userId));
    }
    public static Specification<User> findOrder(Integer userId){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.join("orderProducts").get("user_id"), userId));
    }
    public static Specification<User> equalPrice(Integer age){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("age"),age));
    }


}
/*
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);

        Root<Book> book = cq.from(Book.class);
        Predicate authorNamePredicate = cb.equal(book.get("author"), authorName);
        Predicate titlePredicate = cb.like(book.get("title"), "%" + title + "%");
        cq.where(authorNamePredicate, titlePredicate);

        TypedQuery<Book> query = em.createQuery(cq);
        return query.getResultList();
--------------------------------------------------------------------------------------------------------------------------

        Predicate hasBirthday = builder.equal(root.get(Customer_.birthday), today);
        Predicate isLongTermCustomer = builder.lessThan(root.get(Customer_.createdAt), today.minusYears(2);
        query.where(builder.and(hasBirthday, isLongTermCustomer));
 */