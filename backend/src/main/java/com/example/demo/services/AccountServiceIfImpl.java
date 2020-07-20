package com.example.demo.services;

import com.example.demo.entities.Account;
import com.example.demo.repositories.AccountRepositoryIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceIfImpl implements AccountServiceIf {

    @Autowired
    AccountRepositoryIf accountRepositoryIf;

    public Account saveNewAccount(Account account) {
        return accountRepositoryIf.save(account);
    }

    public Iterable<Account> listAllAccounts() {
        return accountRepositoryIf.findAll();
    }
}
