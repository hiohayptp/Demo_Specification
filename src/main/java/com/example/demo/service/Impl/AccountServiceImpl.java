package com.example.demo.service.Impl;

import com.example.demo.repository.AccountRepository;
import com.example.demo.entity.Account;
import com.example.demo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    AccountRepository repository;
    @Override
    public Account findById(Integer id) {
        Account account = new Account();
        Optional<Account> optional = repository.findById(id);
        if (optional.isPresent())
            account = optional.get();
        return account;
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = repository.findAll();
        return accounts;
    }
}
