package com.example.demo.mapper;

import com.example.demo.dto.OrderProductDTO;
import com.example.demo.entity.OrderProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderProductMapper {
    @Mapping(target = "product", ignore = true)
    OrderProduct orderProductDtoToOrderProduct(OrderProductDTO orderProductDTO);
    @Mapping(target = "product", ignore = true)
    OrderProductDTO orderProductToOrderProductDto(OrderProduct orderProduct);
    List<OrderProduct> listOrderProductDtoToOrderProduct(List<OrderProductDTO> orderProductDTOs);
    List<OrderProductDTO> listOrderProductToOrderProductDto(List<OrderProduct> orderProducts);

}
