package com.account.users.services;

import com.account.users.dao.AccountRepository;
import com.account.users.entities.Account;
import com.account.users.structures.UserStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public Account signIn(String user, String pass) {
        return repository.signIn(user, pass);
    }

    public List<Account> accounts() {
        return repository.accounts();
    }

    public Account signUp(Account account) {
        return repository.signUp(account);
    }

    public Account updateAccount(Account account, Integer verify_otp) {
        return repository.updateAccount(account, verify_otp);
    }

    public void deleteAccount(String id) {
        repository.deleteAccount(id);
    }
}