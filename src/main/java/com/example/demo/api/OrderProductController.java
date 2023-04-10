package com.example.demo.api;

import com.example.demo.dto.OrderProductDTO;
import com.example.demo.entity.OrderProduct;
import com.example.demo.service.Impl.OrderProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/order_product")
public class OrderProductController {

    @Autowired
    OrderProductServiceImpl service;

    @PostMapping("/find_order_product/")
    public ResponseEntity<List<OrderProduct>> findByUserIdAndProductName(@RequestParam ("id") Integer userId, String productName){
        List<OrderProduct> orderProducts = service.findByUserIdAndProductName(userId,productName);
        if (orderProducts == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/find_product_id/{id}")
    public ResponseEntity<List<OrderProductDTO>> findByProductId(@PathVariable("id")Integer id){
        List<OrderProductDTO> orderProducts = service.findByProductId(id);
        if (orderProducts == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orderProducts,HttpStatus.OK);
    }
    @GetMapping("/find_user_id/{id}")
    public ResponseEntity<List<OrderProduct>> findByUserId(@PathVariable("id")Integer id){
        List<OrderProduct> orderProducts = service.findByUserId(id);
        if (orderProducts == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
