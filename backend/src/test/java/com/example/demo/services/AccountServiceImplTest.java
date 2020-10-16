package com.example.demo.services;

import com.example.demo.entities.Account;
import com.example.demo.repositories.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AccountServiceImplTest {

    AccountRepository accountRepository = mock(AccountRepository.class);
    AccountService accountService;

    @BeforeEach
    void init(){
        accountService = new AccountServiceImpl(accountRepository);
    }

    @Test
    void isAccountSavedCorrectly() {
        Account account = Account.builder()
                .email("email")
                .name("testName")
                .surname("testSurname")
                .nickname("Testcik")
                .password("psswd")
                .build();

        when(accountRepository.save(any(Account.class))).thenReturn(account);

        Account created = accountService.saveNewAccount(account);

        assertThat(created).isSameAs(account);
    }

    @Test
    void listAllAccounts() {
    }
}