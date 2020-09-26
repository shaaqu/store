package com.example.demo.services;

import com.example.demo.entities.Account;
import com.example.demo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AcountService {

    @Autowired
    AccountRepository accountRepository;

    public Account saveNewAccount(Account account) {
        return accountRepository.save(account);
    }

    public Iterable<Account> listAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account listAccount(String email) {
        return accountRepository.getAccountByEmail(email);
    }
}
