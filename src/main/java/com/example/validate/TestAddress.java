package com.example.validate;

import java.text.Normalizer;
import java.util.regex.Pattern;


public class TestAddress {
    public static void main(String[] args) {
        CustomerAddressDTO customerAddressDTO = null;
        String a = "114 Thăng Long, Phường 4, Tân Bình, Thành phố Hồ Chí Minh";
        validateCustomerRequest(a);
    }

    private static void validateCustomerRequest(String a) {
        String[] split = a.split(",");
        String province = formatAddress(split[split.length - 1].trim(), LocationTypeEnum.PROVINCE);
        String district = formatAddress(split[split.length - 2].trim(), LocationTypeEnum.DISTRICT);
        String ward = formatAddress(split[split.length - 3].trim(), LocationTypeEnum.WARD);
        System.out.println("Province: " + province);
        System.out.println("District: " + district);
        System.out.println("Ward: " + ward);
    }

    private static String formatAddress(String address, LocationTypeEnum locationTypeEnum) {
        if (address.isEmpty()) {
            return null;
        }
        address = Normalizer.normalize(address, Normalizer.Form.NFD);
        address = address.replaceAll("\\p{InCombiningDiacriticalMarks}+","");
        address = address.toLowerCase().replace("đ" , "d").trim();
        return address;
    }

}

