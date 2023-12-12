package com.example.nasdak.Controller;

import com.example.nasdak.Domain.Category;
import com.example.nasdak.Domain.Users;
import com.example.nasdak.Dto.CategoryDto;
import com.example.nasdak.Dto.UsersDto;
import com.example.nasdak.Service.CategoryService;
import com.example.nasdak.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/category/")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    UserService userService;

    @Autowired
    ModelMapper modelMapper;
    @RequestMapping("basicCategory")
    public void basicCategory(@RequestBody UsersDto usersDto){
        String[] strArray = {"여행", "취미", "식당", "가전", "게임"};

        Users users = userService.searchUserId(usersDto.getUserId());

        CategoryDto categoryDto = new CategoryDto();
        for (int i = 0; i < strArray.length; i++) {
            categoryDto.setUsersDto(modelMapper.map(users, UsersDto.class));
            categoryDto.setContent(strArray[i]);
            categoryService.save(modelMapper.map(categoryDto, Category.class));
        }
    }

    @RequestMapping("categoryList")
    public List<CategoryDto> categoryList(@RequestBody CategoryDto categoryDto){




        System.out.println("categoryDto = " + categoryDto);
        List<Category> categoryList = categoryService.categoryUserList(modelMapper.map(categoryDto, Category.class));

        return categoryList.stream()
                            .map(category -> modelMapper.map(category, CategoryDto.class))
                            .collect(Collectors.toList());
    }



}
