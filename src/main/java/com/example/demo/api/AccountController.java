package com.example.demo.api;

import com.example.demo.entity.Account;
import com.example.demo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    IAccountService iService;
    @GetMapping("/{id}")
    public ResponseEntity<Account> findAccountById(@PathVariable("id") Integer id){
        Account account= iService.findById(id);
        if(account == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(account,HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<Account> findAllAccount(){
        List<Account> accounts= iService.findAll();
        if(accounts == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(accounts,HttpStatus.OK);
    }
}
