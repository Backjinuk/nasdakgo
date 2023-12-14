package com.example.nasdak.Dto;

import com.example.nasdak.Domain.Category;
import com.example.nasdak.Domain.Users;
import com.example.nasdak.Utils.DataUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LedgerDto {

    private long fileManagerNo;

    private UsersDto usersDto;

    private CategoryDto categoryDto;

    private long price;

    private long dw;

    private String location;

    private String comment;

    private LocalDateTime regDate = DataUtils.parseDateTime(DataUtils.getCurrentDateTimeAsString());

    private Users users;

    private Category category;

    private long userNo;

    private String regDate2;

    private String originRegDat;
}
