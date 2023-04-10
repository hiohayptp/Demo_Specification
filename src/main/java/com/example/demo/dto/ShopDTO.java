package com.example.demo.dto;

import com.example.demo.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopDTO {
    private int id;
    @NotNull
    private String title;
    @NotNull
    private String address;
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")
    private String email;
    @Pattern(regexp = "/^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$/") // ngày, tháng và năm
    private Timestamp createDate;
    @Pattern(regexp = "/^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$/") // ngày, tháng và năm
    private Timestamp lastUpdatedDate;
    private List<Product> products;
}
