package com.example.nasdak.Service;

import com.example.nasdak.Domain.Users;
import com.example.nasdak.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public void save(Users users){
        userRepository.save(users);
    }

    public void userUpdate(Users user) { userRepository.userUpdate(user.getUserNo(), user.getEmail(), user.getPhone()); }

    public Users findById(long userNo) {
        return userRepository.findById(userNo).get();
    }
}
