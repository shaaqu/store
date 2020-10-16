package com.example.demo.services;

import com.example.demo.entities.Account;
import com.example.demo.enums.Roles;
import com.example.demo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account saveNewAccount(Account account) {
        account.setRole(Roles.ROLE_USER);
        return accountRepository.save(account);
    }

    public Iterable<Account> listAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccount(String email) {
        return accountRepository.getAccountByEmail(email);
    }
}
