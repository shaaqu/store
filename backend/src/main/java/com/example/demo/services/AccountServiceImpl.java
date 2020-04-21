package com.example.demo.services;

import com.example.demo.entities.Account;
import com.example.demo.repositories.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    IAccountRepository iAccountRepository;

    public Account saveNewAccount(Account account) {
        return iAccountRepository.save(account);
    }

    public Iterable<Account> listAllAccounts() {
        return iAccountRepository.findAll();
    }
}
