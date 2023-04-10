package com.example.demo.mapper;

import com.example.demo.dto.ShopDTO;
import com.example.demo.entity.Shop;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ShopMapper {
    Shop shopDtoToShop(ShopDTO shopDTO);
    ShopDTO shopToShopDto(Shop shop);

    List<ShopDTO> listShopToListShopDto(List<Shop> shops);
}
