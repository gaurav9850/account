package com.account.users.dao;

import com.account.users.entities.Account;
import com.account.users.structures.UserStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepository implements UserStructure {
    @Autowired
    private AccountRepositoryImpl repository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account signIn(String user, String pass) {
        return repository.signIn(user, pass);
    }

    @Override
    public List<Account> accounts() {
        return repository.findAll();
    }

    @Override
    public Account signUp(Account account) {
        return repository.save(account);
    }

    @Override
    public Account updateAccount(Account account, Integer verify_otp) {
        account.setVerify_otp(verify_otp);
        return repository.save(account);
    }

    @Override
    public void deleteAccount(String id) {
        repository.deleteById(id);
    }

    public int update(String msg) {
        int row = jdbcTemplate.update("update user_account set message=?", new Object[]{msg});
        return row;
    }
}