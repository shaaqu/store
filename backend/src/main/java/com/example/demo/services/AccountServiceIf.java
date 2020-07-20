package com.example.demo.services;

import com.example.demo.entities.Account;
import org.springframework.stereotype.Service;


public interface AccountServiceIf {

    Account saveNewAccount(Account account);

    Iterable<Account> listAllAccounts();

}
