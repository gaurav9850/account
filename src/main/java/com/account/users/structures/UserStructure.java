package com.account.users.structures;

import com.account.users.entities.Account;
import java.util.List;

public interface UserStructure {
    Account signIn(String user, String pass);

    List<Account> accounts();

    Account signUp(Account account);

    Account updateAccount(Account account, Integer verify_otp);

    void deleteAccount(String id);
}