package com.account.users.controllers;

import com.account.users.entities.Account;
import com.account.users.services.AccountService;
import com.account.users.util.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
public class AccountController {

    @Autowired
    private AccountService service;

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @GetMapping("/")
    public String index() {
        return "USER-SERVICE";
    }

    @GetMapping("/users")
    public List<Account> users() {
        return service.accounts();
    }

    @GetMapping("/sign-in")
    public Object signIn(@RequestParam("user") String user,
                         @RequestParam("pass") String pass) {

        return service.signIn(user, pass);
    }

    @PostMapping("/sign-up")
    public Account signUp(@RequestBody Account account, @RequestParam(value = "otp", defaultValue = "0", required = false) Integer otp) {
        Account account1 = new Account(account.getName(), account.getLast_name(), account.getEmail(), account.getAddress(),
                account.getPhone(), account.getPassword(), "pending", otp, 0);

        Account account2 = service.signUp(account1);

        return account2;
    }

    @GetMapping("/notification")
    public Map notification(@RequestParam("message") String msg){
        return restTemplateUtil.notificationMail(msg);
    }
}