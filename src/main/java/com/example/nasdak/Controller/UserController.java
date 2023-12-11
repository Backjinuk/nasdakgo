package com.example.nasdak.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @RequestMapping("/api/users/rest/test")
    public String test(){
        return "react hello";
    }
}
