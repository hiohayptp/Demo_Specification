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
@Table(name = "shop")
public class Shop implements Serializable {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "address")
    private String address;
    ///////////////
    @Column(name = "email")
    private String email;
    @Column(name = "created_date")
    private Timestamp createDate;
    @Column(name = "last_updated_date")
    private Timestamp lastUpdatedDate;
    ///////////////
    @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> products;

}
