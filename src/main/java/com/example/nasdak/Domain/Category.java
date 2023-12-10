package com.example.nasdak.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_no")
    private long categoryNo;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private Users users;

    @Column(name = "del_yn")
    private String delYn;



}
