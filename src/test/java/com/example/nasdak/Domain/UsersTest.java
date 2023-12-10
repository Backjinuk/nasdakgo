package com.example.nasdak.Domain;

import com.example.nasdak.Utils.DataUtils;
import com.example.nasdak.Dto.UsersDto;
import com.example.nasdak.Service.UserService;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsersTest {

    @Autowired
    UserService userService;

    @Autowired
     ModelMapper modelMapper;

    @Test
    public void userSave(){
        UsersDto usersDto = new UsersDto();
        usersDto.setEmail("backj123@fgi.kr");
        usersDto.setPassword("0000");
        usersDto.setPhone("010-1111-1111");
        usersDto.setRegDate(DataUtils.parseDateTime(DataUtils.getCurrentDateTimeAsString()));

        userService.save(modelMapper.map(usersDto, Users.class));
    }
}