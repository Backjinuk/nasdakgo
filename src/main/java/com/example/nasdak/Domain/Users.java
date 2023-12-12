package com.example.nasdak.Domain;

import com.example.nasdak.Utils.DataUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id @GeneratedValue
    @Column(name = "user_no")
    private long userNo;

    @Column(name = "user_id")
    private String userId;

    private String password;

    private String email;

    private String phone;

    @Column(name = "reg_date")
    private LocalDateTime regDate = DataUtils.parseDateTime(DataUtils.getCurrentDateTimeAsString());

}
