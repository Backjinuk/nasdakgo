package com.example.nasdak.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {

    private long userNo;

    private String password;

    private String email;

    private String phone;

    private LocalDateTime regDate;
}
