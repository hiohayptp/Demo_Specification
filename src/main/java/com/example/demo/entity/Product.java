package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "price")
    private int price;
    ///////////
    @Column(name = "image")
    private String image;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "sold")
    private int sold;
    @Column(name = "created_date")
    private Timestamp createDate;
    @Column(name = "last_updated_date")
    private Timestamp lastUpdatedDate;
//    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<OrderProduct> orderProducts;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "shop_id", insertable = false, updatable = false)
    private Shop shop;
}
