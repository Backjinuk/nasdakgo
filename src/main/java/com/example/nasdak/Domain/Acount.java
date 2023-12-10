package com.example.nasdak.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Acount {

    @Id @GeneratedValue
    @Column(name = "account_no")
    private long accountNo;

    private String bank;

    @Column(name =  "account_number")
    private String accountNumber;

    @Column(name = " account_password")
    private String accountPassword;

    @Column(name = "reg_date")
    private LocalDateTime regDate;
}
