package com.example.nasdak.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Request_board extends FileManager {

//    @Id @GeneratedValue
//    @Column(name = "request_no")
//    private long requestNo;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private Users users;

    private String Content;

    private String title;

    @Column(name = "regDate")
    private LocalDateTime regDate;
}
