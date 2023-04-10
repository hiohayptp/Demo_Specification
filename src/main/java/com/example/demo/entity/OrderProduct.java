package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_product")
public class OrderProduct implements Serializable {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "total")
    private int total;
//    @Column(name = "user_id")
//    private int userId;
//    @Column(name = "product_id")+
//    private int productId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "product_id", name = "product_id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "user_id", insertable = false, updatable = false)
    private User user;
}
