package com.example.nasdak.Domain;

import com.example.nasdak.Dto.CategoryDto;
import com.example.nasdak.Service.CategoryService;
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

    @Autowired
    CategoryService categoryService;


    @Test
    public void userSave(){
        UsersDto usersDto = new UsersDto();
        usersDto.setEmail("backj123@fgi.kr");
        usersDto.setPassword("0000");
        usersDto.setPhone("010-1111-1111");
        usersDto.setRegDate(DataUtils.parseDateTime(DataUtils.getCurrentDateTimeAsString()));

        userService.save(modelMapper.map(usersDto, Users.class));
    }

    @Test
    public void userUpdate(){
        UsersDto usersDto = new UsersDto();
        usersDto.setUserNo(1L);
        usersDto.setEmail("backj123@naver.com");
        usersDto.setPhone("010-2222-3333");


        userService.userUpdate(modelMapper.map(usersDto, Users.class));

    }

    @Test
    public void categorySave(){
        CategoryDto categoryDto = new CategoryDto();
        Users users = userService.findById(1L);

        for (int i = 0; i < 5; i++) {
            categoryDto.setUsersDto(modelMapper.map(users, UsersDto.class));
            categoryDto.setContent("테스트입니다." + i);
            categoryDto.setDelYn("N");

            categoryService.save(modelMapper.map(categoryDto, Category.class));
        }

    }

    @Test
    public void categoryAppend(){

        CategoryDto categoryDto = new CategoryDto();
        Users users = userService.findById(1L);

        categoryDto.setUsersDto(modelMapper.map(users, UsersDto.class));
        categoryDto.setContent("새로운 카테고리" );
        categoryDto.setDelYn("N");

        categoryService.save(modelMapper.map(categoryDto, Category.class));

    }

    @Test
    public void categoryUpdate(){
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setCollectionNo(8L);
        categoryDto.setContent("카테고리 수정");

        categoryService.categoryUpdate(modelMapper.map(categoryDto, Category.class));

    }

    @Test
    public void categoryDelete(){
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setCollectionNo(8L);

        categoryService.categoryDelete(modelMapper.map(categoryDto, Category.class));
    }

}