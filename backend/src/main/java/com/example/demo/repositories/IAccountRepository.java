package com.example.demo.repositories;

import com.example.demo.entities.Account;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

@EnableJpaRepositories
public interface IAccountRepository extends CrudRepository<Account, String>, PagingAndSortingRepository<Account, String> {

    Account save(Account account);

    Iterable<Account> findAll();
}
