package com.example.demo.mapper;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "orderProducts", ignore = true)
    @Mapping(target = "shop", ignore = true)
    Product productDtoToProduct(ProductDTO productDTO);
    @Mapping(target = "shop", ignore = true)
    @Mapping(target = "orderProducts", ignore = true)
    ProductDTO productToProductDto(Product product);
    List<Product> listProductDtoToListProduct(List<ProductDTO> productDTOs);
    List<ProductDTO> listProductToListProductDto(List<Product> products);

}
