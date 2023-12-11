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
public class Collection {

    @Id @GeneratedValue
    @JoinColumn(name = "collection_no")
    private long collectionNo;

    @ManyToOne
    @JoinColumn(name = "user_no") // Users 클래스의 userNo 필드와 연결
    private Users users;

    private String title;

    @Column(name = "reg_date")
    private LocalDateTime regDate;

}
