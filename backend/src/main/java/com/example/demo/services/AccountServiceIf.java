package com.example.demo.services;

import com.example.demo.entities.Account;

public interface AccountServiceIf {

    Account saveNewAccount(Account account);

    Iterable<Account> listAllAccounts();

}
