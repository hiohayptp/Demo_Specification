package com.example.demo.service;

import com.example.demo.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IAccountService {
    Account findById(Integer id);
    List<Account> findAll();
}
