package com.example.nasdak.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "board_category")
public class FileManager {

    @Id @GeneratedValue
    @Column(name="file_manager_no")
    private long fileManagerNo;

}
