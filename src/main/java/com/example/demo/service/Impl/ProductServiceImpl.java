package com.example.demo.service.Impl;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.OrderProduct;
import com.example.demo.entity.Product;
import com.example.demo.entity.Shop;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repository.OrderProductRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ShopRepository;
import com.example.demo.repository.specifition.ProductSpecification;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ProductRepository repository;
    @Autowired
    ProductMapper mapper;
    @Autowired
    ShopRepository shopRepository;

    public List<Product> findById(Integer id){
        List<Product> products = repository.findAll(ProductSpecification.findOrder(id));

        return products;
    }
    public List<Product> search(String keySearch){
        List<Product> products = repository.findAll(ProductSpecification.search(keySearch));

        return products;
    }

    public List<Product> searchByTitle(String title){
        List<Product> products = repository.findByShopTitle(title);
        return products;
    }
    public List<Product> findByNameSort(String name){
        List<Product> products = repository.findByProductNameLikeOrderByProductNameAsc(name);
        return products;
    }
    public List<Product> findByNameLike(String name){
        List<Product> products = repository.findByProductNameLike(name);
        return products;
    }
    public List<Product> findByShopSort(String title){
        List<Product> products = repository.findByShopTitleOrderByShopTitleAsc(title);
        return products;
    }
    public List<Product> getAll(){
        List<Product> products = repository.findAll();
        return products;
    }

    ///////////////////

    public Product create(Product product){
        repository.save(product);
        return product;
    }
    public ProductDTO update(ProductDTO productDto){
        Product product = mapper.productDtoToProduct(productDto);
        Optional<Product> update = repository.findById(product.getId());
        if (update.isPresent()){
            repository.save(product);
        }
        return productDto;
    }
    public Product delete(Integer id){
        Product product = null;
        Optional<Product> optional = repository.findById(id);
        if (optional.isPresent()){
            product = optional.get();
            repository.delete(product);
        }
        return product;
    }


    public ProductDTO findProduct(Integer id){
        Product product;
        ProductDTO productDTO = null;
        Optional<Product> optional = repository.findById(id);
        if (optional.isPresent()){
            product = optional.get();
            productDTO =  mapper.productToProductDto(product);
        }
        return productDTO;
    }
}

