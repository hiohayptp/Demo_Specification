package com.example.demo.api;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.service.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<List<Product>> findById(@PathVariable("id") Integer id){
        List<Product> products = service.findById(id);
        if (products == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> search(@RequestParam("keySearch") String keySearch){
        List<Product> products = service.search(keySearch);
        if (products == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/search/title")
    public ResponseEntity<List<Product>> searchByTitle(@RequestParam("title") String title){
        List<Product> products = service.searchByTitle(title);
        if (products == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/search/orderByName")
    public ResponseEntity<List<Product>> findByNameSort(@RequestParam("name") String name){
        List<Product> products = service.findByNameSort(name);
        if (products == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/search/findTitle")
    public ResponseEntity<List<Product>> findByShopTitleSort(@RequestParam("title")String title){
        List<Product> products = service.findByShopSort(title);
        if (products == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/search/name")
    public ResponseEntity<List<Product>> findByProductName(@RequestParam("name")String name){
        List<Product> products = service.findByNameLike(name);
        if (products == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Product> create(@RequestBody Product product){
        Product product1 = service.create(product);
        if (product1 == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(product1, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO productDTO){
        ProductDTO productDTO1 = service.update(productDTO);
        if (productDTO1 == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productDTO1, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = service.getAll();
        if (products == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ProductDTO> getAll(@PathVariable("id")Integer id){
        ProductDTO product = service.findProduct(id);
        if (product == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(product, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id")Integer id){
        Product product = service.delete(id);
        if (product == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(product, HttpStatus.OK);
    }
}
