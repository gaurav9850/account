package com.account.users.util;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;

@Service
public class NumberGenerator {
    public int generate() {

        Random rand = new Random();
        HashSet<Integer> set = new HashSet<>();
        int number = rand.nextInt(9999999);
        int count = 0;

       while (set.isEmpty()){
           set.add(number);
       }

        for (Integer numbers : set) {
            count = numbers;
        }
        return count;
    }
}