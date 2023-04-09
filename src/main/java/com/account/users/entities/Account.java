package com.account.users.entities;

import com.account.users.constants.Time;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "user_account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    private String uuid;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String last_name;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String email;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String address;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String phone;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String country;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String password;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String status;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer otp;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer verify_otp;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String message;
    private Long creation_ts;
    private Long modify_ts;

    public Account(String name, String last_name, String email, String address, String phone, String password, String status, Integer otp, Integer verify_otp) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.country = "91";
        this.password = password;
        this.status = status;
        this.otp = otp;
        this.verify_otp = verify_otp;
        this.creation_ts = Time.EPOCH_SECOND;
        this.modify_ts = 0L;
    }

    public Account(String id, String name, String last_name, String email, String address, String phone, String password, String status, Integer otp, Integer verify_otp, Long creation_ts) {
        this.uuid = id;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.country = "91";
        this.password = password;
        this.status = status;
        this.otp = otp;
        this.verify_otp = verify_otp;
        this.creation_ts = creation_ts;
        this.modify_ts = Time.EPOCH_SECOND;
    }
}