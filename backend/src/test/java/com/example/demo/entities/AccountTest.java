package com.example.demo.entities;

import com.example.demo.repositories.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class AccountTest {

    @Autowired
    AccountRepository accountRepository;

    @Disabled
    @Test
    public void savingCorrectRole(){
        Account account = new Account();
        account.setEmail("email");
        account.setName("test");
        account.setSurname("testor");
        account.setNickname("tescik");
        account.setPassword("xddd");
        accountRepository.save(account);
        //Iterable<Account> accounts = accountRepository.findAll();
//        System.out.println(accounts.iterator().next().getRole());
//        assertTrue(account.getRole() == "user");
    }

}