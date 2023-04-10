package com.example.demo.dto;

import com.example.demo.entity.Account;
import com.example.demo.entity.OrderProduct;
import com.example.demo.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int id;
    private String name;
    private int age;
    private String address;
    private Account account;
    private List<OrderProduct> orderProducts;
    private List<Product> products;

}
