package com.example.checkdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddressDTO {
    private String type;
    private String address;
    private String provinceName;
    private String districtName;
    private String wardName;
    private String province;
    private String district;
    private String ward;
    private String accommodationType;
}
