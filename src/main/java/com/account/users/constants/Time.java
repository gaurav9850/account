package com.account.users.constants;

import java.util.Date;

public interface Time {
    Long EPOCH_SECOND = Long.parseLong(String.valueOf(System.currentTimeMillis() / 1000));
    Long EPOCH = Long.parseLong(String.valueOf(new Date().getTime() / 1000));
}