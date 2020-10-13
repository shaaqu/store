package com.example.demo.controllers;

import com.example.demo.entities.Account;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@CrossOrigin
@RestController
public class AccountController {

    AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public ResponseEntity<Account> create(@RequestBody @Valid @NotNull Account account){
        accountService.saveNewAccount(account);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public Iterable<Account> listAccounts(Model model){
        return accountService.listAllAccounts();
    }

    @RequestMapping(value = "/account/{email}", method = RequestMethod.GET)
    public Account listAccount(@PathVariable String email) {
        return accountService.getAccount(email);
    }

}
