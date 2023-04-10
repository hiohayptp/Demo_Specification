package com.example.demo.api;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ShopDTO;
import com.example.demo.service.Impl.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/shop")
public class ShopController {
    @Autowired
    ShopServiceImpl service;

    @GetMapping("/all")
    public ResponseEntity<List<ShopDTO>> getAll(){
        List<ShopDTO> shops = service.getAll();
        if (shops == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<ShopDTO> create(@RequestBody ShopDTO dto){
        ShopDTO shops = service.create(dto);
        if (shops == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ShopDTO> update(@RequestBody ShopDTO dto){
        ShopDTO shops = service.update(dto);
        if (shops == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ShopDTO> delete(@PathVariable("id") Integer id){
        ShopDTO shops = service.delete(id);
        if (shops == null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(shops, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all-shop")
    public ResponseEntity<List<ShopDTO>> getAllShop(){
        return ResponseEntity.ok(service.getAll());
    }
}
