package com.example.demo.service.Impl;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ShopDTO;
import com.example.demo.entity.Shop;
import com.example.demo.mapper.ShopMapper;
import com.example.demo.repository.ShopRepository;
import com.example.demo.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements IShopService {
    @Autowired
    ShopRepository repository;
    @Autowired
    ShopMapper mapper;
    public List<ShopDTO> getAll(){
        List<ShopDTO> shops = mapper.listShopToListShopDto(repository.findAll());
        return shops;
    }

    public ShopDTO create(ShopDTO dto){
        Shop shop = mapper.shopDtoToShop(dto);
        repository.save(shop);
        return dto;
    }

    public ShopDTO update(ShopDTO dto){
        Shop shop = mapper.shopDtoToShop(dto);
        Optional<Shop> optional = repository.findById(shop.getId());
        if (optional.isPresent()){
            repository.save(shop);
        }
        return dto;
    }

    public ShopDTO delete(Integer id){
        Shop shop = null;
        Optional<Shop> optional = repository.findById(id);
        if (optional.isPresent()){
            shop = optional.get();
            repository.delete(shop);
        }
        return mapper.shopToShopDto(shop);
    }
}
