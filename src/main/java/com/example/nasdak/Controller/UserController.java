package com.example.nasdak.Controller;

import com.example.nasdak.Domain.Users;
import com.example.nasdak.Dto.UsersDto;
import com.example.nasdak.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/")
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping("test")
    public String test(){
        return "react hello";
    }

    @RequestMapping("findUserId")
    public int findUserId(@RequestBody UsersDto usersDto){
        Users byId = userService.searchUserId(usersDto.getUserId());
        return (byId == null) ? 0 : 1 ;
    }

    @RequestMapping("userLogin")
    public UsersDto userLogin(@RequestBody UsersDto usersDto){

        System.out.println("usersDto = " + usersDto);
        Users users = userService.userLogin(modelMapper.map(usersDto, Users.class));

        return modelMapper.map(users, UsersDto.class);
    }

    @RequestMapping("userJoin")
    public UsersDto userJoin(@RequestBody UsersDto usersDto){
        Users users = userService.userJoin(modelMapper.map(usersDto, Users.class));

        return modelMapper.map(users, UsersDto.class);
    }

}
