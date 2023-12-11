package com.example.nasdak.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private long collectionNo;

    private UsersDto usersDto;

    private String content;

    private String delYn;

}
