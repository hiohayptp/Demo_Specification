package com.example.checkdate;

import com.example.validate.LocationTypeEnum;
import org.apache.commons.lang.StringUtils;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        List<CustomerAddressDTO> customerAddress = new ArrayList<CustomerAddressDTO>();
        CustomerAddressDTO cus1 = CustomerAddressDTO.builder()
                .address("NGÃ TƯ SỞ, ĐỐNG ĐA, HÀ NỘI")
                .provinceName("HÀ NỘI")
                .districtName("ĐỐNG ĐA")
                .wardName("NGÃ TƯ SỞ")
                .type("ADDRESS_LIVE")
                .build();
        CustomerAddressDTO cus2 = CustomerAddressDTO.builder()
                .address("NGÃ TƯ SỞ, ĐỐNG ĐA, HÀ NỘI")
                .provinceName("HÀ NỘI")
                .districtName("ĐỐNG ĐA")
                .wardName("NGÃ TƯ SỞ")
                .type("ADDRESS_PERMANENT")
                .build();
        customerAddress.add(cus1);
        customerAddress.add(cus2);
        CustomerAddressDTO cus3 = CustomerAddressDTO.builder()
                .address("PVDD, phuong Linh Dong,Quan Thu Duc")
                .provinceName("Thu Duc")
                .districtName("Linh Dong")
                .wardName("PVDD")
                .build();
        System.out.println("------------------" + cus3);
        validateCustomerRequest(customerAddress);
    }
    private static void validateCustomerRequest(List<CustomerAddressDTO> customerAddressRequests) {
        for (CustomerAddressDTO customerAddressDTO : customerAddressRequests) {
            if (StringUtils.isEmpty(customerAddressDTO.getWardName())
                    || StringUtils.isEmpty(customerAddressDTO.getDistrictName())
                    || StringUtils.isEmpty(customerAddressDTO.getProvinceName())) {
                String[] splitCustomerAddressRequest = customerAddressDTO.getAddress().split(",");
                if (customerAddressDTO.getType().equals(AddressTypeEnum.ADDRESS_LIVE.toString())){
                    System.out.println("ADDRESS_LIVE");
                    customerAddressDTO.setProvinceName(
                            formatAddress(splitCustomerAddressRequest[splitCustomerAddressRequest.length - 1].trim(),
                                    LocationTypeEnum.PROVINCE));
                    customerAddressDTO.setDistrictName(
                            formatAddress(splitCustomerAddressRequest[splitCustomerAddressRequest.length - 2].trim(),
                                    LocationTypeEnum.DISTRICT));
                    customerAddressDTO.setWardName(
                            formatAddress(splitCustomerAddressRequest[splitCustomerAddressRequest.length - 3].trim(),
                                    LocationTypeEnum.WARD));
                    customerAddressDTO.setProvinceName(
                            formatAddress(splitCustomerAddressRequest[splitCustomerAddressRequest.length - 1].trim(),
                                    LocationTypeEnum.PROVINCE));
                    customerAddressDTO.setDistrictName(
                            formatAddress(splitCustomerAddressRequest[splitCustomerAddressRequest.length - 2].trim(),
                                    LocationTypeEnum.DISTRICT));
                    customerAddressDTO.setWardName(
                            formatAddress(splitCustomerAddressRequest[splitCustomerAddressRequest.length - 3].trim(),
                                    LocationTypeEnum.WARD));
                }
            } else {
                System.out.println("ADDRESS_PERMANENT");
                customerAddressDTO.setProvinceName(formatAddress(customerAddressDTO.getProvinceName().trim(),
                        LocationTypeEnum.PROVINCE));
                customerAddressDTO.setDistrictName(formatAddress(customerAddressDTO.getDistrictName().trim(),
                        LocationTypeEnum.DISTRICT));
                customerAddressDTO.setWardName(formatAddress(customerAddressDTO.getWardName().trim(),
                        LocationTypeEnum.WARD));
            }
        }
    }
    private static String formatAddress(String address, LocationTypeEnum locationTypeEnum) {
        if (address.isEmpty()) {
            return null;
        }
        address = Normalizer.normalize(address, Normalizer.Form.NFD);
        address = address.replaceAll("\\p{InCombiningDiacriticalMarks}+","");
        address = address.toLowerCase().replace("đ" , "d").trim();
        System.out.println(address);
        return address;
    }

}
