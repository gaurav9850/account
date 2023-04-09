package com.account.users.dao;

import com.account.users.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface AccountRepositoryImpl extends JpaRepository<Account,String> {
    @Transactional
    @Query(value = "select * from user_account where name=:user and password=:pass",nativeQuery = true)
    Account signIn(@Param("user") String user,@Param("pass") String pass);
}
