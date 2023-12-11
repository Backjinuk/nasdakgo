package com.example.nasdak.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request_comment {

    @Id @GeneratedValue
    @Column(name = "answer_no")
    private long answerNo;

    @ManyToOne
    @JoinColumn(name = "request_no")
    private Request_board requestBoard;

    private String comment;

    @Column(name = "reg_date")
    private LocalDateTime regDate;
}
