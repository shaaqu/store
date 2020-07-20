package com.example.demo.controllers;

import com.example.demo.entities.Account;
import com.example.demo.services.AccountServiceIf;
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

    @Autowired
    AccountServiceIf accountServiceIf;


    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public ResponseEntity<Account> create(@RequestBody @Valid @NotNull Account account){
        accountServiceIf.saveNewAccount(account);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Listing all 'accounts' from database.
     * @param model
     * @return all 'accounts' from database
     */
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public Iterable<Account> list(Model model){
        return accountServiceIf.listAllAccounts();
    }
}
