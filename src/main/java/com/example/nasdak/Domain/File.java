package com.example.nasdak.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class File {

    @Id @GeneratedValue
    @Column(name = "file_no")
    private long fileNo;

    @Column(name = "file_path")
    private String filePath;
}
