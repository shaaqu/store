package com.example.demo.services;

import com.example.demo.entities.Account;
import org.springframework.stereotype.Service;


public interface AccountService {

    Account saveNewAccount(Account account);

    Iterable<Account> listAllAccounts();

    Account getAccount(String email);
}
