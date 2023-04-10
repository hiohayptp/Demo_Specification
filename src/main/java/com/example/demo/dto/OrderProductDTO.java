package com.example.demo.dto;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductDTO {
    private int id;
    private int total;
//    private int userId;
//    private int productId;
    private ProductDTO product;
    private UserDTO user;

}
