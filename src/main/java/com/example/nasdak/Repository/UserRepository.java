package com.example.nasdak.Repository;

import com.example.nasdak.Domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;

public interface UserRepository extends JpaRepository<Users, Long> {

    @Modifying
    @Transactional
    @Query(value =
            "UPDATE Users u " +
            "   SET u.email= :email ," +
                    "u.phone= :phone " +
            "WHERE u.user_no= :userNo ",
            nativeQuery = true)
    void userUpdate(long userNo, String email, String phone);


    @Query(value =
            "SELECT * " +
                "FROM Users u " +
            "WHERE u.user_id= :userId " +
            "AND u.password= :password"
            , nativeQuery = true)
    Users userLogin(String userId, String password);

    @Query(value =
            "SELECT * FROM " +
                "Users u " +
            "WHERE u.user_id = :userId",
            nativeQuery = true)
    Users findByUserId(String userId);
}
