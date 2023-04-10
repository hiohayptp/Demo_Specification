package com.example.demo.dto;

import com.example.demo.entity.OrderProduct;
import com.example.demo.entity.Shop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private int id;
    private String productName;
    private String image;
    private int price;
    private int quantity;
    private int sold;
    @Pattern(regexp = "/^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$/") // ngày, tháng và năm
    private Timestamp createDate;
    @Pattern(regexp = "/^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$/") // ngày, tháng và năm
    private Timestamp lastUpdatedDate;
    private List<OrderProduct> orderProducts;
    private Shop shop;
}
